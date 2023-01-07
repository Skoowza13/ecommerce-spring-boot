package com.ecom.app.ws.repositories;

import com.ecom.app.ws.entities.CartShopEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartShopRepository extends PagingAndSortingRepository<CartShopEntity,Long> {

    @Query(value="SELECT*FROM cart_shop c where c.cart_id='6ef3Yb71zM7oAJNfW0MFLgkg6fkP4Y'",nativeQuery = true)
    CartShopEntity findByCartShopId(String cartId);

}
