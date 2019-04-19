package com.anhnguyen.mtadminservice.domain.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BodyUnHoldTicket extends BaseRequest{
    @JsonProperty("id_tran")
    Integer idTrans;

    @Override
    public boolean isVadilate() {
        if(idTrans!=null){
            return true;
        }
        return false;
    }
}
