package vn.identity.services.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import vn.identity.services.api.dto.UserDto;
import vn.identity.services.api.entity.User;
import vn.identity.services.api.repository.UserRepository;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class UserController {

    private final  UserRepository userRepository;


    @GetMapping(name = "/users")
    public List<User> getUers(){
        return  userRepository.findByUserNameEqualsIgnoreCaseAndAgeEquals("",0);
    }

    @PostMapping(name = "/users")
    public User addUser(@RequestBody UserDto userDto){
        User user = User.builder()
                .userName(userDto.getUserName())
                .password(userDto.getPassword())
                .fistName(userDto.getFistName())
                .lastName(userDto.getLastName())
                .age(userDto.getAge())
                .gender(userDto.getGender())
                .address(userDto.getAddress())
                .build();
        return userRepository.save(user);
    }
}
