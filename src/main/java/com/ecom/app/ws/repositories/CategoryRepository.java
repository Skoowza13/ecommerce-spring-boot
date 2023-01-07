package com.ecom.app.ws.repositories;

import com.ecom.app.ws.entities.CategoryEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends PagingAndSortingRepository<CategoryEntity,Long> {


}
