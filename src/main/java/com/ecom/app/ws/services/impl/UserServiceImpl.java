package com.ecom.app.ws.services.impl;

import com.ecom.app.ws.entities.UserEntity;
import com.ecom.app.ws.repositories.UserRepository;
import com.ecom.app.ws.services.UserService;
import com.ecom.app.ws.shared.Utils;
import com.ecom.app.ws.shared.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    Utils util;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDto createUser(UserDto user) {

        UserEntity checkUser = userRepository.findByEmail(user.getEmail());

        if(checkUser!=null) throw new RuntimeException("user was already exist !");


        UserEntity userEntity = new UserEntity();

        BeanUtils.copyProperties(user,userEntity);

        userEntity.setUserId(util.generateStringId(32));
        userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        UserEntity newUser = userRepository.save(userEntity);

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(newUser,userDto);

        return userDto;
    }

    @Override
    public UserDto getUser(String email) {

        UserEntity userEntity =userRepository.findByEmail(email);

        if(userEntity==null) throw new UsernameNotFoundException(email);

        UserDto userDto=new UserDto();

        BeanUtils.copyProperties(userEntity, userDto);

        return userDto;
    }

    @Override
    public UserDto getUserByUserId(String userId) {

        UserEntity userEntity=userRepository.findByUserId(userId);

        if(userEntity==null) throw new UsernameNotFoundException(userId);

        UserDto userDto=new UserDto();

        BeanUtils.copyProperties(userEntity, userDto);

        return userDto;
    }

    @Override
    public UserDto updateUser(String userId, UserDto userDto) {


        UserEntity userEntity=userRepository.findByUserId(userId);

        if(userEntity==null) throw new UsernameNotFoundException(userId);

        userEntity.setFirstName(userDto.getFirstName());
        userEntity.setLastName(userDto.getLastName());
        userEntity.setPhone(userDto.getPhone());

        UserEntity userUpdated =userRepository.save(userEntity);

        UserDto user=new UserDto();

        BeanUtils.copyProperties(userUpdated, user);

        return user;
    }

    @Override
    public UserDto deleteUser(String userId) {
        UserEntity userEntity=userRepository.findByUserId(userId);

        if(userEntity==null) throw new UsernameNotFoundException(userId);

        userRepository.delete(userEntity);
        return null;

    }

    @Override
    public List<UserDto> getUsers(int page, int limit) {

        if(page>0) page -=1; //page=page-1

        List<UserDto> usersDto=new ArrayList<>();

        Pageable pageableRequest = PageRequest.of(page, limit);

        Page<UserEntity> userPage=userRepository.findAll(pageableRequest);

        List<UserEntity> users = userPage.getContent();

        for(UserEntity userEntity:users ) {

            UserDto user = new UserDto();
            BeanUtils.copyProperties(userEntity, user);

            //ModelMapper modelMapper = new ModelMapper();
            //modelMapper.map(userEntity, UserDto.class);
            usersDto.add(user);
        }

        return usersDto;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        UserEntity userEntity = userRepository.findByEmail(email);

        if(userEntity==null) throw new UsernameNotFoundException(email);

        return new User(userEntity.getEmail(),userEntity.getEncryptedPassword(),new ArrayList<>());
    }
}
