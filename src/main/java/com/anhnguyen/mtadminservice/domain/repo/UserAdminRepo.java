package com.anhnguyen.mtadminservice.domain.repo;

import com.anhnguyen.mtadminservice.domain.mysql.UserAdminEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAdminRepo extends CrudRepository<UserAdminEntity, Integer> {
    UserAdminEntity findByUsername(String username);
}
