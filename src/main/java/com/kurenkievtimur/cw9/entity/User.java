package com.kurenkievtimur.cw9.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user", schema = "public")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class User extends BaseIdEntity {
    @Column(name = "name", length = 25)
    String name;

    @Column(name = "email", length = 25)
    String email;

    @Column(name = "username", length = 25)
    String username;

    @Column(name = "password")
    String password;

    @Column(name = "locked")
    @Builder.Default
    boolean locked = false;

    @Column(name = "enabled")
    @Builder.Default
    boolean enabled = true;

    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    List<Role> roles;

    @OneToMany(mappedBy = "user")
    List<Task> tasks;
}
