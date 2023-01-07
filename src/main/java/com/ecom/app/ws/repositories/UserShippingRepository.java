package com.ecom.app.ws.repositories;

import com.ecom.app.ws.entities.UserShipping;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserShippingRepository extends PagingAndSortingRepository<UserShipping,Long> {

}
