package com.anhnguyen.mtadminservice.domain.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class UserChangePasswordRequest extends BaseRequest {
    @JsonProperty("old_password")
    private String oldPassword;
    @JsonProperty("new_password")
    private String newPassword;

    @Override
    public boolean isVadilate() {
        if(isNullOrEmpty(oldPassword)|| isNullOrEmpty(newPassword)){
            return false;
        }
        return true;
    }
}
