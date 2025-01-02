package com.uberApp.entities;

import com.uberApp.entities.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "app_user", indexes = {
        @Index(name = "idx_user_email", columnList = "email")
})
@Getter
@Setter
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//sequence will create another table for us

    private String name;

    @Column(unique = true)
    private String email;
    private String password;


    //it will create another table for roles//appuserroles table
    @ElementCollection(fetch = FetchType.EAGER)//Ensures that the roles are loaded immediately with the main entity instead of being lazily loaded.
    @Enumerated(EnumType.STRING) // Maps the enum as a string in the database
    private Set<Role> roles;//(e.g., "ADMIN", "DRIVER", "RIDER")

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_"+role.name()))
                .collect(Collectors.toSet());
    }

    @Override
    public String getUsername() {
        return email;
    }
}
