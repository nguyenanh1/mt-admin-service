package com.anhnguyen.mtadminservice.domain.response;

import com.anhnguyen.mtadminservice.domain.mysql.TicketEntity;
import com.anhnguyen.mtadminservice.domain.mysql.ZoomDetailEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ResponseTicket {
    private TicketEntity ticketEntity;
    private ZoomDetailEntity zoomDetailEntity;
}
