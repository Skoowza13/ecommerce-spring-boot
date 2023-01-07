package com.ecom.app.ws.repositories;

import com.ecom.app.ws.entities.OrderEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends PagingAndSortingRepository<OrderEntity,Long> {
      @Query(value="SELECT*FROM orders o where o.order_id='Bs95EGlnSep0PpNkzyTpJae8slRJ0A'",nativeQuery = true)
      OrderEntity findByOrderId(String orderId);

}
