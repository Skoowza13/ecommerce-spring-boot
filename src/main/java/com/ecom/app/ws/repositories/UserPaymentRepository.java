package com.ecom.app.ws.repositories;

import com.ecom.app.ws.entities.UserPayment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPaymentRepository extends PagingAndSortingRepository<UserPayment,Long> {

    @Query(value="SELECT*FROM user_payment u where u.user_payment_id='feEJ2egLOssnfJaMzCk9Lcz5H3MQs8'",nativeQuery = true)
    UserPayment findAllByUserPaymentId(String userPaymentId);
}
