package com.ecom.app.ws.repositories;

import com.ecom.app.ws.entities.PaymentEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends PagingAndSortingRepository<PaymentEntity,Long> {

    @Query(value="SELECT*FROM payment p where p.payment_id='kTjoRr5ZSe8KRq29fS0hnlYT5Pt9Dh'",nativeQuery = true)
    PaymentEntity findByPaymentId(String paymentId);

}
