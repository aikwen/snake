package com.snake.backend.controller.user;

import com.snake.backend.mapper.UserMapper;
import com.snake.backend.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    UserMapper userMapper;

    @GetMapping("all/")
    public List<User> allUser(){
        return userMapper.selectList(null);
    }

    @GetMapping("{userId}/")
    public User getUserById(@PathVariable int userId){
        return userMapper.selectById(userId);
    }

    @GetMapping("/add/{userId}/{username}/{password}/")
    public String addUser(
            @PathVariable int userId,
            @PathVariable String username,
            @PathVariable String password){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(password);
        User user = new User(userId,username,encodedPassword);
        userMapper.insert(user);
        return "Add User Successfully";
    }

    @GetMapping("/delete/{userId}/")
    public String deleteUserById(@PathVariable int userId){
        userMapper.deleteById(userId);
        return "Delete User Successfully";
    }
}
