package com.anhnguyen.mtadminservice.domain.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class CateogryRequest {
    String name;

    @Override
    public String toString() {
        return "CateogryRequest{" +
                "name='" + name + '\'' +
                '}';
    }
}
