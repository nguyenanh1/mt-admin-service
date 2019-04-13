package com.anhnguyen.mtadminservice.common;

import io.swagger.annotations.ApiModel;
import lombok.Getter;


/**
 * @author Rin
 */

@Getter
@ApiModel(description = "Định nghĩa mã code trả về")
public enum ErrorType {
    SUCCESS("200", "SUCCESS"),
    SYSTEM_ERROR("001", "SYSTEM_ERROR"),
    ARGUMENT_NOT_VALID("002", "ARGUMENT_NOT_VALID"),
    USER_NOT_EXITS("003","USER_NOT_EXITS"),
    PASSWORD_WRONG("004","PASSWORD_WRONG"),
    LOGIN_OTHER_DEVICE("005","LOGIN_OTHER_DEVICE"),
    USER_REGISTER_EXITS("006","USER_REGISTER_EXITS"),
    TOKEN_IN_VALID("007","TOKEN_IN_VALID"),
    TOKEN_IS_EMPTY("008","TOKEN_IS_EMPTY"),
    LIST_EMPTY("009","LIST_EMPTY"),
    OBJECT_EMPTY("010","OBJECT_EMPTY")
    ;

    private String code;

    private String mesg;

    ErrorType(String code, String mesg) {
        this.code = code;
        this.mesg = mesg;
    }
}
