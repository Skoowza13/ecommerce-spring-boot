package com.ecom.app.ws.services;

import com.ecom.app.ws.shared.dto.ProductDto;


public interface ProductService {
    ProductDto getOneProduct(String productId);

    ProductDto createProduct(ProductDto productDto, String email);
}
