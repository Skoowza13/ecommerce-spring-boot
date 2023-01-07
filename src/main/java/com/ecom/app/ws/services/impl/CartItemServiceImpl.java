package com.ecom.app.ws.services.impl;

import com.ecom.app.ws.entities.CartItem;
import com.ecom.app.ws.entities.CartShopEntity;
import com.ecom.app.ws.entities.OrderEntity;
import com.ecom.app.ws.entities.ProductEntity;
import com.ecom.app.ws.repositories.CartItemRepository;
import com.ecom.app.ws.repositories.CartShopRepository;
import com.ecom.app.ws.repositories.OrderRepository;
import com.ecom.app.ws.repositories.ProductRepository;
import com.ecom.app.ws.services.CartItemService;
import com.ecom.app.ws.services.ProductService;
import com.ecom.app.ws.shared.Utils;
import com.ecom.app.ws.shared.dto.CartItemDto;
import com.ecom.app.ws.shared.dto.CartShopDto;
import com.ecom.app.ws.shared.dto.OrderDto;
import com.ecom.app.ws.shared.dto.ProductDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CartShopRepository cartShopRepository;

    @Autowired
    CartItemRepository cartItemRepository;

    @Autowired
    Utils utils;

    @Override
    public CartItemDto createCartItem(CartItemDto cartItem, String product_id, String orderId, String cartId) {

        ProductEntity product=productRepository.findByProductId(product_id);

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);
        ProductDto productDto=modelMapper.map(product,ProductDto.class);

        OrderEntity order =orderRepository.findByOrderId(orderId);
        OrderDto orderDto =modelMapper.map(order, OrderDto.class);

        CartShopEntity cartShop=cartShopRepository.findByCartShopId(cartId);
        CartShopDto cartShopDto =modelMapper.map(cartShop, CartShopDto.class);

        cartItem.setCartItemId(utils.generateStringId(30));
        cartItem.setProduct(productDto);
        cartItem.setOrder(orderDto);
        cartItem.setCartShop(cartShopDto);

        CartItem cartItem1 =modelMapper.map(cartItem,CartItem.class);

        CartItem newCartItem =cartItemRepository.save(cartItem1);

        CartItemDto cartItemDto=modelMapper.map(newCartItem,CartItemDto.class);

        return cartItemDto;
    }
}
