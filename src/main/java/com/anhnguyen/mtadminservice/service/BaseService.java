package com.anhnguyen.mtadminservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;

public class BaseService {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    protected Timestamp currrentTime(){
        return new Timestamp(System.currentTimeMillis());
    }
}
