package com.kurenkievtimur.cw9.dto.user;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CreateUserDto {
    @Size(min = 2, max = 25, message = "${user.error.size.name}")
    String name;

    @Size(min = 2, max = 25, message = "${user.error.size.email}")
    String email;

    @Size(min = 2, max = 25, message = "${user.error.size.username}")
    String username;

    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,16}$", message = "")
    String password;

    Long roleId;
}
