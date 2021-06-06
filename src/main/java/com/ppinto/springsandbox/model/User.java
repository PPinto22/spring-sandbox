package com.ppinto.springsandbox.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "sandbox_users")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ElementCollection(fetch = FetchType.EAGER)
    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    @Singular
    private Set<UserRole> roles;

    @ElementCollection
    @OrderColumn
    @Singular
    private List<Address> addresses;
}
