package com.ecom.app.ws.controllers;


import com.ecom.app.ws.requests.CategoryRequest;
import com.ecom.app.ws.responses.CategoryResponse;
import com.ecom.app.ws.services.CategoryService;
import com.ecom.app.ws.shared.dto.CategoryDto;
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
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity<CategoryResponse> createCategory(@RequestBody CategoryRequest categoryRequest){

        ModelMapper modelMapper = new ModelMapper();

        CategoryDto categoryDto = modelMapper.map(categoryRequest,CategoryDto.class);

        CategoryDto createCategory = categoryService.createCategory(categoryDto);

        CategoryResponse categoryResponse = modelMapper.map(createCategory,CategoryResponse.class);

        return new ResponseEntity<CategoryResponse>(categoryResponse, HttpStatus.CREATED);
    }

}
