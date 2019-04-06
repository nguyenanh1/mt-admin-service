package com.anhnguyen.mtadminservice.service;

import com.anhnguyen.mtadminservice.domain.mysql.UserEntity;

public interface IUserService {
    int save(UserEntity userEntity);
    UserEntity findByUserId(Integer id);
    UserEntity findByEmail(String email);
}
