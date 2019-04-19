package com.anhnguyen.mtadminservice.domain.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BodyListTicket extends BaseRequest{
    @JsonProperty("list")
    List<Integer> mListId;

    @Override
    public boolean isVadilate() {
        if(mListId!=null&&mListId.size()>0){
            return true;
        }
        return false;
    }
}
