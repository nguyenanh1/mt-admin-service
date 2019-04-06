package com.anhnguyen.mtadminservice.domain.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
public class LoginRequest {
    private String username;
    private String password;
    private String os_id;
    private String device_id;

    public boolean isVadialte(){
        if(username==null||password==null||os_id==null||device_id==null){
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "LoginRequest{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", os_id='" + os_id + '\'' +
                ", device_id='" + device_id + '\'' +
                '}';
    }
}
