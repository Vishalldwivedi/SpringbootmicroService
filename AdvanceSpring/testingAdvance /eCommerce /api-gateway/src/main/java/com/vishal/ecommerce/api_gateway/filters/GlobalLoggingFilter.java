package com.vishal.ecommerce.api_gateway.filters;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@Slf4j//adding this globalLogginFilter in filter Chain
public class GlobalLoggingFilter implements GlobalFilter, Ordered {

//exchange will have the req and response related to this filter ,chain is the all the filters
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
       //not return something because filters will modify the
        // req and res that is coming inside the exchange
        //as there are multiple concurrent request .
        log.info("Logging from Global Pre: {}", exchange.getRequest().getURI());

        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            log.info("Logging from Global Post: {}", exchange.getResponse().getStatusCode());
        }));
    }
    @Override
    public int getOrder() {
        return 5;
    }
}
