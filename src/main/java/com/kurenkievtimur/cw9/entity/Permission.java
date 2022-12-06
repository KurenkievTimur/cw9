package com.kurenkievtimur.cw9.entity;

import com.kurenkievtimur.cw9.util.enums.PermissionType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "permission")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Permission extends BaseIdEntity {
    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    PermissionType name;

    @ManyToMany(mappedBy = "permissions")
    List<Role> roles;
}
