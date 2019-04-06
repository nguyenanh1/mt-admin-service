package com.anhnguyen.mtadminservice.service.impl;

import com.anhnguyen.mtadminservice.common.ErrorType;
import com.anhnguyen.mtadminservice.domain.mysql.UserAdminEntity;
import com.anhnguyen.mtadminservice.domain.repo.UserAdminRepo;
import com.anhnguyen.mtadminservice.domain.request.LoginRequest;
import com.anhnguyen.mtadminservice.domain.response.Result;
import com.anhnguyen.mtadminservice.service.BaseService;
import com.anhnguyen.mtadminservice.service.IUserAdminService;
import com.anhnguyen.mtadminservice.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserAdminService extends BaseService implements IUserAdminService {

    @Autowired
    private UserAdminRepo mUserAdminRepo;

    @Override
    public UserAdminEntity findById(Integer id) {
        return null;
    }

    @Override
    public UserAdminEntity findByUsername(String username) {
        try {
            return mUserAdminRepo.findByUsername(username);
        }catch (Exception e){
            logger.error("[User Admin Service] Error: {}",e);
            return null;
        }
    }

    @Override
    public List<UserAdminEntity> findAll() {
        return null;
    }

    @Override
    public int save(UserAdminEntity userAdminEntity) {
        try {
            mUserAdminRepo.save(userAdminEntity);
            return 1;
        }catch (Exception e){
            logger.error("[User Admin Service] Error: {}",e);
            return 0;
        }
    }


    @Override
    public int delete(UserAdminEntity userAdminEntity) {
        try {
            mUserAdminRepo.delete(userAdminEntity);
            return 1;
        }catch (Exception e){
            logger.error("[User Admin Service] Error: {}",e);
            return 0;
        }
    }

    public Result login(LoginRequest loginRequest) {
        UserAdminEntity user = findByUsername(loginRequest.getUsername());
        if(user!=null){
            if(loginRequest.getPassword().equals(user.getPassword())){
                if(user.getToken()==null){
                    HashMap<String,String> map = new HashMap<>();
                    map.put("user_id",String.valueOf(user.getId()));
                    map.put("roles",String.valueOf(user.getRole()));
                    map.put("device_id",String.valueOf(loginRequest.getDevice_id()));
                    String token = JwtUtils.generate(map);
                    user.setLastLogin(currrentTime());
                    user.setToken(token);
                    save(user);
                    return Result.success(user);
                }else {
                    return  Result.fail(ErrorType.LOGIN_OTHER_DEVICE);
                }
            }else {
                return Result.fail(ErrorType.PASSWORD_WRONG);
            }
        }else {
            return Result.fail(ErrorType.USER_NOT_EXITS);
        }
    }
}
