package com.ecom.app.ws.repositories;

import com.ecom.app.ws.entities.UserDetailEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepository extends PagingAndSortingRepository<UserDetailEntity,Long> {

    @Query(value="SELECT*FROM user_detail_entity u where u.user_detail_id='3M70CdcC3CLtzwdWQ9KNbAF20ngFO9'",nativeQuery = true)
    UserDetailEntity findByUserDetailId(String userDetailId);

}
