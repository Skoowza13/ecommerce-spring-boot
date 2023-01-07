package com.ecom.app.ws.repositories;

import com.ecom.app.ws.entities.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<UserEntity,Long> {

    UserEntity findByEmail(String email);

    UserEntity findByUserId(String userId);

    @Query(value="SELECT * FROM users u WHERE u.first_name=?1 OR u.last_name=?1",nativeQuery = true)
    Page<UserEntity> findAllUserByCriteria(Pageable pageableRequest);


}
