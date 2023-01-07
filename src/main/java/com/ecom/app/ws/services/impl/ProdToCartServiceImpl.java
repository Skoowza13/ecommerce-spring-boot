package com.ecom.app.ws.services.impl;

import com.ecom.app.ws.entities.CartItem;
import com.ecom.app.ws.entities.ProductEntity;
import com.ecom.app.ws.entities.ProductToCartItem;
import com.ecom.app.ws.repositories.CartItemRepository;
import com.ecom.app.ws.repositories.ProdToCartItemRepository;
import com.ecom.app.ws.repositories.ProductRepository;
import com.ecom.app.ws.services.ProdToCartService;
import com.ecom.app.ws.shared.Utils;
import com.ecom.app.ws.shared.dto.CartItemDto;
import com.ecom.app.ws.shared.dto.ProdToCartDto;
import com.ecom.app.ws.shared.dto.ProductDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdToCartServiceImpl implements ProdToCartService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    CartItemRepository cartItemRepository;
    @Autowired
    ProdToCartItemRepository prod;
    @Autowired
    Utils utils;

    @Override
    public ProdToCartDto addProdToCartItem(ProdToCartDto prodToCart, String product_id, String cartItemId) {

        ProductEntity product =productRepository.findByProductId(product_id);

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);
        ProductDto productDto = modelMapper.map(product, ProductDto.class);

        CartItem cart = cartItemRepository.findByCartItemId(cartItemId);
        CartItemDto cartItemDto = modelMapper.map(cart, CartItemDto.class);

        prodToCart.setProdToItemId(utils.generateStringId(30));
        prodToCart.setProduct(productDto);
        prodToCart.setCart(cartItemDto);

        ProductToCartItem productToCartItem =modelMapper.map(prodToCart, ProductToCartItem.class);

        ProductToCartItem addProdItem =prod.save(productToCartItem);

        ProdToCartDto prodToCartDto =modelMapper.map(addProdItem, ProdToCartDto.class);

        return prodToCartDto;
    }
}
