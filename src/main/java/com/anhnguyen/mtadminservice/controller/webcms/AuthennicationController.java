package com.anhnguyen.mtadminservice.controller.webcms;

import com.anhnguyen.mtadminservice.common.ErrorType;
import com.anhnguyen.mtadminservice.controller.BaseController;
import com.anhnguyen.mtadminservice.domain.request.LoginRequest;
import com.anhnguyen.mtadminservice.domain.response.Result;
import com.anhnguyen.mtadminservice.service.impl.UserAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authenication")
public class AuthennicationController extends BaseController {
    @Autowired
    UserAdminService mUserAdminService;

    @PostMapping(value = "/login")
    public Result login(@RequestBody LoginRequest loginRequest){
        logger.info("[Authenication Controller] Authenication Login Body: {}",loginRequest);
        Result result;
        if(loginRequest.isVadialte()){
             result = mUserAdminService.login(loginRequest);
        }else {
             result = Result.fail(ErrorType.ARGUMENT_NOT_VALID);
        }

        return result;
    }
}
