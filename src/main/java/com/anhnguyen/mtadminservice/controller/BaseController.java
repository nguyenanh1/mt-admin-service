package com.anhnguyen.mtadminservice.controller;

import com.anhnguyen.mtadminservice.common.ErrorType;
import com.anhnguyen.mtadminservice.domain.mysql.UserEntity;
import com.anhnguyen.mtadminservice.util.JwtUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public abstract class BaseController {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    protected Integer checkToken(String token){
        Map<String, String> map = JwtUtils.validate(token);
        String id = map.get("user_id");
        try{
           return Integer.parseInt(id);
        }catch (Exception e){
            return null;
        }
    }
}
