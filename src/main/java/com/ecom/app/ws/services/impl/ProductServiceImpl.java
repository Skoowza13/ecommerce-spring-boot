package com.ecom.app.ws.services.impl;

import com.ecom.app.ws.entities.ProductEntity;
import com.ecom.app.ws.entities.UserEntity;
import com.ecom.app.ws.repositories.ProductRepository;
import com.ecom.app.ws.repositories.UserRepository;
import com.ecom.app.ws.services.ProductService;
import com.ecom.app.ws.shared.Utils;
import com.ecom.app.ws.shared.dto.ProductDto;
import com.ecom.app.ws.shared.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    Utils utils;

    @Override
    public ProductDto getOneProduct(String id) {
        return null;
    }

    @Override
    public ProductDto createProduct(ProductDto product, String email) {

        UserEntity currentUser = userRepository.findByEmail(email);

        ModelMapper modelMapper = new ModelMapper();
        UserDto userDto =modelMapper.map(currentUser, UserDto.class);

        product.setProduct_Id(utils.generateStringId(30));
        product.setUser(userDto);

        ProductEntity productEntity=modelMapper.map(product,ProductEntity.class);

        ProductEntity newProduct = productRepository.save(productEntity);

        ProductDto productDto = modelMapper.map(newProduct,ProductDto.class);

        return productDto;
    }
}
