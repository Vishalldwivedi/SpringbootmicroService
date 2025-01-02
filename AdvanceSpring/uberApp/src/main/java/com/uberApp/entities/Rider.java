package com.uberApp.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Rider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne//by default eager loading connect one table to another each rider will have one user
    @JoinColumn(name = "user_id")//Foreign key column
    //this user_id FK will be mapped to User primay key .
    private User user;

    private Double rating;
}
