package com.balanced.app.ws;

import com.balanced.app.ws.io.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

     UserEntity findByEmail(String email);

}
