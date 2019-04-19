package com.anhnguyen.mtadminservice.domain.response;

import com.anhnguyen.mtadminservice.domain.mysql.TicketEntity;
import com.anhnguyen.mtadminservice.domain.mysql.ZoomDetailEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketResponse {
    private TicketEntity ticket;
    private ZoomDetailEntity position;
}
