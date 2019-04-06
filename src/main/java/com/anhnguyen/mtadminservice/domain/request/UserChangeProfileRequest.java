package com.anhnguyen.mtadminservice.domain.request;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class UserChangeProfileRequest extends BaseRequest {
    private String lastname;
    private String name;
    private Long birthday;
    private Integer gender;
    private String phone;
    private String address;

    @Override
    public boolean isVadilate() {
        if(isNullOrEmpty(lastname)|| isNullOrEmpty(name)||birthday==null||
                isNull(gender)||isNullOrEmpty(phone)||isNullOrEmpty(address)){
            return false;
        }
        return true;
    }
}
