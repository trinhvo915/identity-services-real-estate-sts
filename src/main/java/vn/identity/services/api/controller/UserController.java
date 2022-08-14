package vn.identity.services.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import vn.identity.services.api.dto.UserDto;
import vn.identity.services.api.entity.User;
import vn.identity.services.api.repository.UserRepository;
import vn.identity.services.api.service.user.UserService;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @GetMapping(name = "/users")
    public void addUser() throws IOException {
        userService.saveDiem();
    }



}
