package com.anhnguyen.mtadminservice.domain.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class UserChangeAvatarRequest  extends BaseRequest{
    @JsonProperty("avatar_url")
    private String avatarUrl;

    @Override
    public boolean isVadilate() {
        if(isNullOrEmpty(avatarUrl)){
            return false;
        }
        return true;
    }
}
