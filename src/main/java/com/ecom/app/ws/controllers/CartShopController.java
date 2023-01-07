package com.ecom.app.ws.controllers;

import com.ecom.app.ws.repositories.CartShopRepository;
import com.ecom.app.ws.requests.CartShopRequest;
import com.ecom.app.ws.responses.CartShopResponse;
import com.ecom.app.ws.services.CartShopService;
import com.ecom.app.ws.shared.dto.CartShopDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("cart-shop")
public class CartShopController {

    @Autowired
    CartShopService cartShopService;

    @PostMapping("create")
    public ResponseEntity<CartShopResponse> createCartShop(@RequestBody CartShopRequest cartShopRequest, Principal principal){

        ModelMapper modelMapper=new ModelMapper();

        CartShopDto cartShopDto=modelMapper.map(cartShopRequest,CartShopDto.class);

        CartShopDto createCartShop=cartShopService.createShopCart(cartShopDto,principal.getName());

        CartShopResponse cartShopResponse=modelMapper.map(createCartShop, CartShopResponse.class);

        return new ResponseEntity<CartShopResponse>(cartShopResponse, HttpStatus.CREATED);
    }
}
