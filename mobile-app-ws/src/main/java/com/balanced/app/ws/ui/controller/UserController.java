package com.balanced.app.ws.ui.controller;

import com.balanced.app.ws.model.request.UserDetailsRequestModel;
import com.balanced.app.ws.model.response.UserRest;
import com.balanced.app.ws.service.UserService;
import com.balanced.app.ws.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users") // http://localhost:8080/users
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public String getUser(){
        return "get user was called";
    }



    @PostMapping
    public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails){
        //Create object to return
        UserRest returnValue = new UserRest();

        //Create dto and Copy details from userRequest in to user request into dto
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetails,userDto);

        // call user service that creates user.
        UserDto createdUser = userService.createUser(userDto);

        // copy data from the returned createdUser  into UserResponse object

        BeanUtils.copyProperties(createdUser,returnValue);

        return returnValue;
    }



    @PutMapping
    public String updateUser(){
        return "update user was called";
    }



    @DeleteMapping
    public String deleteUser(){
        return "delete user was called";
    }
}
