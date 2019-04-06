package com.anhnguyen.mtadminservice.controller;

import com.anhnguyen.mtadminservice.common.ErrorType;
import com.anhnguyen.mtadminservice.domain.request.*;
import com.anhnguyen.mtadminservice.domain.response.Result;
import com.anhnguyen.mtadminservice.service.IUserService;
import com.anhnguyen.mtadminservice.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/authenication/user")
public class UserAuthenController extends BaseController {

    @Autowired
    private UserService mUserService;

    @PostMapping("/register")
    public Result register(@RequestBody UserRegisterRequest registerRequest) {
        logger.info("/register request: {}" + registerRequest);
        Result result = null;
        if (registerRequest.isVadilate()) {
            result = mUserService.register(registerRequest);
        } else {
            result = Result.fail(ErrorType.ARGUMENT_NOT_VALID);
        }
        return result;
    }

    @GetMapping("/profile")
    public Result getProfile(@RequestHeader("token") String token) {
        logger.info("[get profile]get profile with token {}", token);
        Result result = null;
        if (token != null && !token.isEmpty()) {
            if (checkToken(token) != null) {
                result = mUserService.getProfile(checkToken(token), token);
            } else {
                result = Result.fail(ErrorType.TOKEN_IN_VALID);
            }
        } else {
            result = Result.fail(ErrorType.TOKEN_IS_EMPTY);
        }
        return result;
    }

    @PostMapping("/login")
    public Result login(@RequestBody UserLoginRequest userLoginRequest) {
        logger.info("[login controller]login with request body {}", userLoginRequest);
        Result result = null;
        if (userLoginRequest.isVadilate()) {
            result = mUserService.login(userLoginRequest);
        } else {
            result = Result.fail(ErrorType.ARGUMENT_NOT_VALID);
        }
        return result;
    }

    @PostMapping("/logout")
    public Result logout(@RequestHeader("token") String token) {
        logger.info("[get profile]get profile with token {}", token);
        Result result = null;
        if (token != null && !token.isEmpty()) {
            if (checkToken(token) != null) {
                result = mUserService.logout(checkToken(token), token);
            } else {
                result = Result.fail(ErrorType.TOKEN_IN_VALID);
            }
        } else {
            result = Result.fail(ErrorType.TOKEN_IS_EMPTY);
        }
        return result;
    }

    @PutMapping("/change-password")
    public Result changProfile(@RequestHeader("token") String token,
                               @RequestBody UserChangePasswordRequest request) {
        logger.info("change password with token: " + token);
        Result result = null;
        if (token != null && !token.isEmpty()) {
            if (checkToken(token) != null) {
                if (request.isVadilate()) {
                    result = mUserService.changePassword(checkToken(token), token, request);
                } else {
                    result = Result.fail(ErrorType.ARGUMENT_NOT_VALID);
                }
            } else {
                result = Result.fail(ErrorType.TOKEN_IN_VALID);
            }
        } else {
            result = Result.fail(ErrorType.TOKEN_IS_EMPTY);
        }
        return result;
    }

    @PutMapping("change-avatar")
    public Result changeAvatar(@RequestHeader("token") String token,
                             @RequestBody UserChangeAvatarRequest request) {
        logger.info("change avatar with token: {} and body {}" ,token,request);
        Result result = null;
        if (token != null && !token.isEmpty()) {
            if (checkToken(token) != null) {
                if (request.isVadilate()) {
                    result = mUserService.changeAvatar(checkToken(token), token, request);
                } else {
                    result = Result.fail(ErrorType.ARGUMENT_NOT_VALID);
                }
            } else {
                result = Result.fail(ErrorType.TOKEN_IN_VALID);
            }
        } else {
            result = Result.fail(ErrorType.TOKEN_IS_EMPTY);
        }
        return result;
    }

    @PutMapping("change-profile")
    public Result changeProfile(@RequestHeader("token")String token,
                                @RequestBody UserChangeProfileRequest request){
        logger.info("change profile with token: {} and body {}" ,token,request);
        Result result = null;
        if (token != null && !token.isEmpty()) {
            if (checkToken(token) != null) {
                if (request.isVadilate()) {
                    result = mUserService.changProfile(checkToken(token), token, request);
                } else {
                    result = Result.fail(ErrorType.ARGUMENT_NOT_VALID);
                }
            } else {
                result = Result.fail(ErrorType.TOKEN_IN_VALID);
            }
        } else {
            result = Result.fail(ErrorType.TOKEN_IS_EMPTY);
        }
        return result;
    }
}
