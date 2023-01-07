package com.ecom.app.ws.services.impl;

import com.ecom.app.ws.entities.CartShopEntity;
import com.ecom.app.ws.entities.UserEntity;
import com.ecom.app.ws.repositories.CartShopRepository;
import com.ecom.app.ws.repositories.UserRepository;
import com.ecom.app.ws.services.CartShopService;
import com.ecom.app.ws.shared.Utils;
import com.ecom.app.ws.shared.dto.CartShopDto;
import com.ecom.app.ws.shared.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartShopServiceImpl implements CartShopService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CartShopRepository cartShopRepository;

    @Autowired
    Utils utils;

    @Override
    public CartShopDto createShopCart(CartShopDto cartShop, String email) {

        UserEntity currentUser =userRepository.findByEmail(email);

        ModelMapper modelMapper=new ModelMapper();
        UserDto userDto =modelMapper.map(currentUser,UserDto.class);

        cartShop.setCartId(utils.generateStringId(30));
        cartShop.setUser(userDto);

        CartShopEntity cartShopEntity=modelMapper.map(cartShop, CartShopEntity.class);

        CartShopEntity newCartShop=cartShopRepository.save(cartShopEntity);

        CartShopDto cartShopDto=modelMapper.map(newCartShop, CartShopDto.class);

        return cartShopDto;
    }
}
