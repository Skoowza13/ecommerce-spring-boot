package com.ecom.app.ws.controllers;


import com.ecom.app.ws.requests.ProductRequest;
import com.ecom.app.ws.responses.ProductResponse;
import com.ecom.app.ws.services.ProductService;
import com.ecom.app.ws.shared.dto.ProductDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/products")
public class ProductController {


    @Autowired
    ProductService productService;


    @GetMapping
    public ResponseEntity<ProductResponse> getProduct(@PathVariable String id){

        ProductDto productDto =productService.getOneProduct(id);

        ProductResponse productResponse = new ProductResponse();

        BeanUtils.copyProperties(productDto, productResponse);

        return new ResponseEntity<ProductResponse>(productResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest productRequest, Principal principal){

        ModelMapper modelMapper= new ModelMapper();

        ProductDto productDto = modelMapper.map(productRequest,ProductDto.class);

        ProductDto createProduct = productService.createProduct(productDto,principal.getName());

        ProductResponse productResponse = modelMapper.map(createProduct,ProductResponse.class);

        return new ResponseEntity<ProductResponse>(productResponse,HttpStatus.CREATED);

    }

    @PutMapping
    public String updatePoduct(){
        return "create product was called";
    }

    @DeleteMapping
    public String deletePoduct(){
        return "create product was called";
    }







}
