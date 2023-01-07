package com.ecom.app.ws.repositories;

import com.ecom.app.ws.entities.CartItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends PagingAndSortingRepository<CartItem,Long> {


    @Query(value = "SELECT*FROM cart_item c where c.cart_item_id='wlglk667ODAoc0fsjoGHqg1bS3TE9e'",nativeQuery = true)
    CartItem findByCartItemId(String cartItemId);
}
