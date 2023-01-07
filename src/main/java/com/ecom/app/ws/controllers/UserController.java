package com.ecom.app.ws.controllers;

import com.ecom.app.ws.exceptions.UserException;
import com.ecom.app.ws.requests.User;
import com.ecom.app.ws.responses.ErrorMessages;
import com.ecom.app.ws.responses.UserResponse;
import com.ecom.app.ws.services.UserService;
import com.ecom.app.ws.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(path = "{id}",produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserResponse> getUser(@PathVariable String id){

        UserDto userDto =userService.getUserByUserId(id);

        UserResponse userResponse = new UserResponse();

        BeanUtils.copyProperties(userDto, userResponse);

        return new ResponseEntity<UserResponse>(userResponse, HttpStatus.OK);
    }

    @Cacheable(value = "users")
    @GetMapping(produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
    public List<UserResponse> getAllUsers(@RequestParam(value="page") int page, @RequestParam(value="limit")int limit) {

        List<UserResponse> usersResponse = new ArrayList<>();

        List<UserDto> users =userService.getUsers(page,limit);

        for(UserDto userDto:users ) {

            UserResponse user = new UserResponse();
            BeanUtils.copyProperties(userDto, user);

            usersResponse.add(user);
        }

        return usersResponse;
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody User userRequest) throws Exception {

        if(userRequest.getFirstName().isEmpty()) throw new UserException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());


        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userRequest, userDto);


        UserDto createUser = userService.createUser(userDto);

        UserResponse userResponse = new UserResponse();

        BeanUtils.copyProperties(createUser,userResponse);

        return new ResponseEntity<UserResponse>(userResponse,HttpStatus.CREATED);
    }

    @PutMapping(path ="{id}")
    public ResponseEntity<UserResponse> updateUSer(@PathVariable String id, @RequestBody User userRequest){
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userRequest, userDto);

        UserDto updateUser =  userService.updateUser(id,userDto);


        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(updateUser, userResponse);

        return new ResponseEntity<UserResponse>(userResponse,HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable String id){
        userService.deleteUser(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}
