package com.balanced.app.ws.impl;

import com.balanced.app.ws.UserRepository;
import com.balanced.app.ws.io.entity.UserEntity;
import com.balanced.app.ws.service.UserService;
import com.balanced.app.ws.shared.Utils;
import com.balanced.app.ws.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    Utils utils;

    @Override
    public UserDto createUser(UserDto user) {

        //check if user exist already
        if(userRepository.findByEmail(user.getEmail()) != null) throw new RuntimeException("Record already exists");
        //create user entity object
        UserEntity userEntity = new UserEntity();
        //add instance field details from user in to User Entity
        BeanUtils.copyProperties(user,userEntity);

        userEntity.setUserId(utils.generateUserId(30));
        userEntity.setEncryptedPassword("test");

        //Save userEntity into database
        UserEntity storedUserDetails = userRepository.save(userEntity);

        //return UserDto
        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(storedUserDetails,returnValue);

        return returnValue;
    }
}
