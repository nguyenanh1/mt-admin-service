package com.anhnguyen.mtadminservice.service.impl;

import com.anhnguyen.mtadminservice.common.ErrorType;
import com.anhnguyen.mtadminservice.domain.mysql.UserEntity;
import com.anhnguyen.mtadminservice.domain.repo.UserRepo;
import com.anhnguyen.mtadminservice.domain.request.*;
import com.anhnguyen.mtadminservice.domain.response.Result;
import com.anhnguyen.mtadminservice.service.BaseService;
import com.anhnguyen.mtadminservice.service.IUserService;
import com.anhnguyen.mtadminservice.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService extends BaseService implements IUserService {

    @Autowired
    private UserRepo mUserRepo;

    public Result register(UserRegisterRequest request){
        Result result = null;
        UserEntity userEntity = findByEmail(request.getEmail());
        if(userEntity == null){
            UserEntity entityRegister = new UserEntity();
            entityRegister.setEmail(request.getEmail());
            entityRegister.setPassword(request.getPassword());
            entityRegister.setLastname(request.getLastname());
            entityRegister.setName(request.getName());
            entityRegister.setBirthday(new Timestamp(request.getBirthday()));
            entityRegister.setGender(request.getGender());
            entityRegister.setPhone(request.getPhone());
            entityRegister.setAddresss(request.getAddress());
            entityRegister.setBalace(0);
            entityRegister.setPoint(0);
            entityRegister.setType(1);
            entityRegister.setAvatar("");
            entityRegister.setCreateBy(1);
            entityRegister.setUpdateBy(1);
            Timestamp timestamp = currrentTime();
            entityRegister.setLastLogin(timestamp);
            entityRegister.setTimeCreate(timestamp);
            entityRegister.setTimeUpdate(timestamp);
            int save = save(entityRegister);
            HashMap<String,String> map = new HashMap<>();
            map.put("user_id",String.valueOf(entityRegister.getId()));
            map.put("roles",String.valueOf(0));
            map.put("device_id",String.valueOf(request.getDevice_id()));
            String token = JwtUtils.generate(map);
            entityRegister.setToken(token);
            int save1 = save(entityRegister);
            if(save==1){
                result = Result.success(entityRegister);
            }else {
                result = Result.fail();
            }
        }else {
            result = Result.fail(ErrorType.USER_REGISTER_EXITS);
        }
        return result;
    }

    public Result getProfile(Integer id,String token) {
        UserEntity userEntity = findByUserId(id);
        Result result = null;
        if(userEntity!=null){
            if(userEntity.getToken().equalsIgnoreCase(token)){
                result = Result.success(userEntity);
            }else {
                result = Result.fail(ErrorType.TOKEN_IN_VALID);
            }
        }else {
            result = Result.fail(ErrorType.TOKEN_IN_VALID);
        }
        return result;
    }

    public ErrorType checkToken(Integer id,String token){
        UserEntity userEntity = findByUserId(id);
        if(userEntity!=null){
            if(userEntity.getToken().equalsIgnoreCase(token)){
                return null;
            }else {
                return ErrorType.TOKEN_IN_VALID;
            }
        }else {
            return ErrorType.TOKEN_IN_VALID;
        }
    }

    @Override
    public int save(UserEntity userEntity) {
        try {
            mUserRepo.save(userEntity);
            return 1;
        } catch (Exception e) {
            logger.error("[User Service] Error to save: []" + e);
            return 0;
        }
    }

    public Result login(UserLoginRequest userLoginRequest) {
        Result result = null;
        UserEntity entity = findByEmail(userLoginRequest.getEmail());
        if(entity!=null){
            if(entity.getToken().isEmpty()){
                if(entity.getPassword().equalsIgnoreCase(userLoginRequest.getPassword())){
                    HashMap<String,String> map = new HashMap<>();
                    map.put("user_id",String.valueOf(entity.getId()));
                    map.put("roles",String.valueOf(0));
                    map.put("device_id",String.valueOf(userLoginRequest.getDevice_id()));
                    entity.setToken(JwtUtils.generate(map));
                    save(entity);
                    result = Result.success(entity);
                }else {
                    result =Result.fail(ErrorType.PASSWORD_WRONG);
                }
            }else {
                result = Result.fail(ErrorType.LOGIN_OTHER_DEVICE);
            }
        }else {
            result =Result.fail(ErrorType.USER_NOT_EXITS);
        }
        return result;
    }

    public Result changePassword(Integer id,String token, UserChangePasswordRequest request) {
        UserEntity userEntity = findByUserId(id);
        Result result = null;
        if(userEntity!=null){
            if(userEntity.getToken().equalsIgnoreCase(token)){
                if(userEntity.getPassword().equalsIgnoreCase(request.getOldPassword())){
                    userEntity.setPassword(request.getNewPassword());
                    save(userEntity);
                    result = Result.success();
                }else {
                   result = Result.fail(ErrorType.PASSWORD_WRONG);
                }
            }else {
                result = Result.fail(ErrorType.TOKEN_IN_VALID);
            }
        }else {
            result = Result.fail(ErrorType.TOKEN_IN_VALID);
        }
        return result;
    }

    public Result logout(Integer id, String token) {
        UserEntity userEntity = findByUserId(id);
        Result result = null;
        if(userEntity!=null){
            userEntity.setToken("");
            save(userEntity);
            result = Result.success();
        }else {
            result = Result.fail(ErrorType.TOKEN_IN_VALID);
        }
        return result;
    }

    public Result changeAvatar(Integer id, String token, UserChangeAvatarRequest request) {
        UserEntity userEntity = findByUserId(id);
        Result result = null;
        if(userEntity!=null){
            if(userEntity.getToken().equalsIgnoreCase(token)){
                userEntity.setAvatar(request.getAvatarUrl());
                save(userEntity);
                result = Result.success();
            }else {
                result = Result.fail(ErrorType.TOKEN_IN_VALID);
            }
        }else {
            result = Result.fail(ErrorType.TOKEN_IN_VALID);
        }
        return result;
    }

    public Result changProfile(Integer id, String token, UserChangeProfileRequest request) {
        UserEntity userEntity = findByUserId(id);
        Result result = null;
        if(userEntity!=null){
            if(userEntity.getToken().equalsIgnoreCase(token)){
                userEntity.setLastname(request.getLastname());
                userEntity.setName(request.getName());
                userEntity.setGender(request.getGender());
                userEntity.setBirthday(new Timestamp(request.getBirthday()));
                userEntity.setAddresss(request.getAddress());
                userEntity.setPhone(request.getPhone());
                save(userEntity);
                result = Result.success();
            }else {
                result = Result.fail(ErrorType.TOKEN_IN_VALID);
            }
        }else {
            result = Result.fail(ErrorType.TOKEN_IN_VALID);
        }
        return result;
    }

    @Override
    public UserEntity findByUserId(Integer id) {
        try {
            Optional<UserEntity> userEntity = mUserRepo.findById(id);
            if(userEntity.isPresent()){
                return userEntity.get();
            }
            return null;
        } catch (Exception e) {
            logger.error("[User Servuce] Error to findByEmail: []" + e);
            return null;
        }
    }

    @Override
    public UserEntity findByEmail(String email) {
        try {
            UserEntity userEntity = mUserRepo.findByEmail(email);
            return userEntity;
        } catch (Exception e) {
            logger.error("[User Servuce] Error to findByEmail: []" + e);
            return null;
        }
    }



}
