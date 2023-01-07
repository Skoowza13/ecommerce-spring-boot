package com.ecom.app.ws.repositories;

import com.ecom.app.ws.entities.ProductToCartItem;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdToCartItemRepository extends PagingAndSortingRepository<ProductToCartItem,Long> {

}
