package com.ecom.app.ws.services.impl;

import com.ecom.app.ws.entities.CategoryEntity;
import com.ecom.app.ws.entities.ProductEntity;
import com.ecom.app.ws.repositories.CategoryRepository;
import com.ecom.app.ws.repositories.ProductRepository;
import com.ecom.app.ws.services.CategoryService;
import com.ecom.app.ws.shared.Utils;
import com.ecom.app.ws.shared.dto.CategoryDto;
import com.ecom.app.ws.shared.dto.ProductDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {


    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categ;

    @Autowired
    Utils utils;

    @Override
    public CategoryDto createCategory(CategoryDto category) {


        ModelMapper modelMapper = new ModelMapper();
        CategoryEntity categoryEntity =modelMapper.map(category,CategoryEntity.class);

        categoryEntity.setCategory_Id(utils.generateStringId(30));


        CategoryEntity newCategory = categ.save(categoryEntity);

        CategoryDto categoryDto = modelMapper.map(newCategory,CategoryDto.class);

        return categoryDto;
    }
}
