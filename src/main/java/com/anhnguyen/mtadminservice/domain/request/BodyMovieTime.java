package com.anhnguyen.mtadminservice.domain.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class BodyMovieTime {
    @JsonProperty("id_movie")
    private int idMovie;
    @JsonProperty("id_room")
    private int idRoom;
    private int price;
    private int time;
    private int date;
}
