package com.ecom.app.ws.services;

import com.ecom.app.ws.shared.dto.UserDto;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

@CacheConfig(cacheNames = "users")
public interface UserService extends UserDetailsService {

    UserDto createUser(UserDto userDto);

    UserDto getUser(String email);

    UserDto getUserByUserId(String userId);

    UserDto updateUser(String id, UserDto userDto);

    UserDto deleteUser(String id);

    List<UserDto> getUsers(int page, int limit);
}
