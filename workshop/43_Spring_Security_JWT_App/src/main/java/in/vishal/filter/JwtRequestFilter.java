package in.vishal.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import in.vishal.security.MyUserDetailsService;
import in.vishal.util.JwtUtil;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {
	//when ever req comes to my app that filder will varify that jwt token is valid or not
	//if request will comes other then authentication
	//

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private MyUserDetailsService userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		// Get Authorization Header from request

		String authHeaderVal = request.getHeader("Authorization");

		// extract username from token

		String username = null;
		String jwt = null;

		// Authorization = Bearer <token>
		if (authHeaderVal != null && authHeaderVal.startsWith("Bearer ")) {
			jwt = authHeaderVal.substring(7);//skip bearer and space string
			username = jwtUtil.extractUsername(jwt);
		}

		// load userdata based on username using UserDetailsService
// when security is not happening for this user name
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = userDetailsService.loadUserByUsername(username);

			// validate token with userdetails

			if (jwtUtil.validateToken(jwt, userDetails)) {
				UsernamePasswordAuthenticationToken unamePwdAuthToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());

				unamePwdAuthToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

				SecurityContextHolder.getContext().setAuthentication(unamePwdAuthToken);
			}
		}

		filterChain.doFilter(request, response);

	}
}
