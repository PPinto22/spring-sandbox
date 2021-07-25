package com.ppinto.springsandbox.model;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@ToString
@Table(name = "sandbox_users")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ElementCollection(fetch = FetchType.EAGER)
    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Set<UserRole> roles = new HashSet<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @OrderColumn
    private List<Address> addresses = new ArrayList<>();

    @OneToOne(mappedBy = "user", orphanRemoval = true, cascade = CascadeType.ALL)
    private UserSettings settings;

    public User(Long id,
                String name,
                Collection<UserRole> roles,
                Collection<Address> addresses,
                UserSettings settings) {
        this.id = id;
        this.name = name;
        this.setRoles(roles);
        this.setAddresses(addresses);
        this.setSettings(settings);
    }

    public void setSettings(UserSettings settings) {
        this.settings = settings;
        if (settings != null) settings.setUser(this);
    }

    public void setRoles(Collection<UserRole> roles) {
        if (roles == null) {
            this.roles.clear();
            return;
        }
        this.roles.retainAll(roles);
        this.roles.addAll(roles);
    }

    public void setAddresses(Collection<Address> addresses) {
        if (addresses == null) {
            this.addresses.clear();
            return;
        }
        this.addresses.retainAll(addresses);
        this.addresses.addAll(addresses);
    }
}
