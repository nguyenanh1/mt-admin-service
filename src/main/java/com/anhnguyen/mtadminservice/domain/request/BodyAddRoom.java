package com.anhnguyen.mtadminservice.domain.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BodyAddRoom {
    private String name;
    private int row;
    private int col;

}
