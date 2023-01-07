package com.ecom.app.ws.controllers;

import com.ecom.app.ws.entities.CartShopEntity;
import com.ecom.app.ws.entities.OrderEntity;
import com.ecom.app.ws.entities.ProductEntity;
import com.ecom.app.ws.requests.CartItemRequest;
import com.ecom.app.ws.responses.CartItemResponse;
import com.ecom.app.ws.services.CartItemService;
import com.ecom.app.ws.shared.dto.CartItemDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("cart-item")
public class CartItemController {


    @Autowired
    CartItemService cartItemService;

    @PostMapping("create")
    public ResponseEntity<CartItemResponse> createCartItem(@RequestBody CartItemRequest cartItemRequest, @ModelAttribute("product_Id") ProductEntity product,@ModelAttribute("orderId") OrderEntity order,@ModelAttribute("cartId") CartShopEntity cartShop){

        ModelMapper modelMapper=new ModelMapper();

        CartItemDto cartItemDto =modelMapper.map(cartItemRequest,CartItemDto.class);

        CartItemDto newCartItem = cartItemService.createCartItem(cartItemDto,product.getProduct_Id(),order.getOrderId(),cartShop.getCartId());

        CartItemResponse cartItemResponse=modelMapper.map(newCartItem, CartItemResponse.class);

        return new ResponseEntity<CartItemResponse>(cartItemResponse, HttpStatus.CREATED);
    }

}
