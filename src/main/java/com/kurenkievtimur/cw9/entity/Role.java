package com.kurenkievtimur.cw9.entity;

import com.kurenkievtimur.cw9.util.enums.RoleType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Role extends BaseIdEntity {
    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    RoleType name;

    @ManyToMany
    @JoinTable(
            name = "role_permission",
            joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id", referencedColumnName = "id"))
    List<Permission> permissions;

    @ManyToMany(mappedBy = "roles")
    List<User> users;
}
