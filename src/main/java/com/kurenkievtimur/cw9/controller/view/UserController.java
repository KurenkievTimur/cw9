package com.kurenkievtimur.cw9.controller.view;

import com.kurenkievtimur.cw9.dto.user.CreateUserDto;
import com.kurenkievtimur.cw9.mapper.role.RoleMapper;
import com.kurenkievtimur.cw9.mapper.user.UserMapper;
import com.kurenkievtimur.cw9.service.role.RoleService;
import com.kurenkievtimur.cw9.service.user.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class UserController {
    UserService userService;
    RoleService roleService;
    RoleMapper roleMapper;
    UserMapper userMapper;

    @GetMapping("/create")
    ModelAndView createPage(@ModelAttribute("userDto") CreateUserDto userDto) {
        return new ModelAndView("/user/create")
                .addObject("roles", roleMapper.convertEntityToDto(roleService.findAll()));
    }

    @PostMapping("/create")
    ModelAndView create(@ModelAttribute("userDto") @Valid CreateUserDto userDto, BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView("/user/create", result.getModel());
        }

        userService.create(userMapper.convertDtoToEntity(userDto));
        return new ModelAndView("redirect:" + "/users/create")
                .addObject("userDto", userDto);
    }
}
