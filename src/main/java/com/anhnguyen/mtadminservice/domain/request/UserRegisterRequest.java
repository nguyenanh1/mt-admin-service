package com.anhnguyen.mtadminservice.domain.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@ToString(callSuper = true)
public class UserRegisterRequest extends BaseRequest{
    private String email;
    private String password;
    private String lastname;
    private String name;
    private Long birthday;
    private Integer gender;
    private String phone;
    private String address;
    @JsonProperty("os_id")
    private Integer os_id;
    @JsonProperty("device_id")
    private String device_id;

    @Override
    public boolean isVadilate(){
        if(isNullOrEmpty(email)||isNullOrEmpty(password)||isNull(os_id)||isNullOrEmpty(device_id)
                ||isNullOrEmpty(phone)||isNullOrEmpty(lastname)||isNullOrEmpty(name)||birthday ==null
                ||isNull(gender)||isNullOrEmpty(address)){
            return false;
        }
        return true;
    }
}
