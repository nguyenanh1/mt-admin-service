package com.anhnguyen.mtadminservice.domain.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class UserLoginRequest extends BaseRequest {
    private String email;
    private String password;
    @JsonProperty("os_id")
    private int os_id;
    @JsonProperty("device_id")
    private String device_id;
    @Override
    public boolean isVadilate() {
        if(isNullOrEmpty(email)||isNullOrEmpty(password)||isNull(os_id)||isNullOrEmpty(device_id)){
            return false;
        }
        return true;
    }
}
