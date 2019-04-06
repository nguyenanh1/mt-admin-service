package com.anhnguyen.mtadminservice.service;

import com.anhnguyen.mtadminservice.domain.mysql.UserAdminEntity;

import java.util.List;

public interface IUserAdminService {
    UserAdminEntity findById(Integer id);
    UserAdminEntity findByUsername(String username);
    List<UserAdminEntity> findAll();
    int save(UserAdminEntity userAdminEntity);
    int delete(UserAdminEntity userAdminEntity);
}
