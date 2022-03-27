package com.user.controller;

import com.user.entity.User;
import com.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/")
    public User saveUser(@RequestBody User user) {
        System.out.println("User Data: " + user);
        userService.saveUserData(user);
        return user;
    }

    @GetMapping("/")
    public List<User> getAllUsers() {
    return userService.findAllUsers();
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") Long userId) {
        System.out.println("GETUSER " + userId);


        User user = userService.getUser(userId);
        System.out.println(user);
        //http://localhost:8081/contact/user/1311

        List contacts = restTemplate.getForObject("http://contactapp:8081/contact/user/" + user.getUserId(), List.class);

        System.out.println(contacts);
        user.setContacts(contacts);
        return user;

    }

}
