package com.ecom.app.ws.repositories;

import com.ecom.app.ws.entities.ProductEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<ProductEntity,Long> {

    @Query(value="SELECT*FROM products where product_id='bdDJGfTacwTtqQaGsy1rOBDgr0KOlF'",nativeQuery = true)
    ProductEntity findByProductId(String productId);
}
