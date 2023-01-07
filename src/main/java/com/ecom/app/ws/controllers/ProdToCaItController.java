package com.ecom.app.ws.controllers;

import com.ecom.app.ws.entities.CartItem;
import com.ecom.app.ws.entities.ProductEntity;
import com.ecom.app.ws.requests.ProdToCArtItemReq;
import com.ecom.app.ws.responses.ProdToCartItResponse;
import com.ecom.app.ws.services.ProdToCartService;
import com.ecom.app.ws.shared.dto.ProdToCartDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("product-cart-item")
public class ProdToCaItController {

    @Autowired
    ProdToCartService prod;

    @PostMapping("add")
    public ResponseEntity<ProdToCartItResponse> addProdToCart(@RequestBody ProdToCArtItemReq prodToCart, @ModelAttribute("productId") ProductEntity product, @ModelAttribute("cartItemId") CartItem cart) {


        ModelMapper modelMapper = new ModelMapper();

        ProdToCartDto prodToCartDto = modelMapper.map(prodToCart, ProdToCartDto.class);

        ProdToCartDto addProdToCart =prod.addProdToCartItem(prodToCartDto,product.getProduct_Id(),cart.getCartItemId());

        ProdToCartItResponse prodToCartItRes = modelMapper.map(addProdToCart, ProdToCartItResponse.class);

        return new ResponseEntity<ProdToCartItResponse>(prodToCartItRes, HttpStatus.CREATED);

    }
}
