package com.anhnguyen.mtadminservice.domain.response;

import com.anhnguyen.mtadminservice.common.ErrorType;
import com.anhnguyen.mtadminservice.exception.BaseException;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import java.time.Instant;
import java.time.ZonedDateTime;

/**
 * @author Rin
 */
@ApiModel(description = "Cấu trúc response")
@Getter
public class Result<T> {
    public static final String SUCCESSFUL_CODE = "200";
    public static final String SUCCESSFUL_MESG = "OK";

    @ApiModelProperty(value = "Mã code", required = true)
    private String code;
    @ApiModelProperty(value = "Mô tả lỗi")
    private String mesg;
    @ApiModelProperty(value = "Thời gian")
    private Instant timestamp;
    @ApiModelProperty(value = "Dữ liệu")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public Result() {
        this.timestamp = ZonedDateTime.now().toInstant();
    }


    public Result(ErrorType errorType) {
        this.code = errorType.getCode();
        this.mesg = errorType.getMesg();
        this.timestamp = ZonedDateTime.now().toInstant();
    }


    public Result(ErrorType errorType, T data) {
        this(errorType);
        this.data = data;
    }


    private Result(String code, String mesg, T data) {
        this.code = code;
        this.mesg = mesg;
        this.data = data;
        this.timestamp = ZonedDateTime.now().toInstant();
    }


    public static Result success(Object data) {
        return new Result<>(SUCCESSFUL_CODE, SUCCESSFUL_MESG, data);
    }


    public static Result success() {
        return success(null);
    }


    public static Result fail() {
        return new Result(ErrorType.SYSTEM_ERROR);
    }


    public static Result fail(BaseException baseException) {
        return fail(baseException, null);
    }


    public static Result fail(BaseException baseException, Object data) {
        return new Result<>(baseException.getErrorType(), data);
    }

    public static Result fail(String code, String msg, Object data) {
        return new Result<>(code, msg, data);
    }


    public static Result fail(ErrorType errorType, Object data) {
        return new Result<>(errorType, data);
    }


    public static Result fail(ErrorType errorType) {
        return Result.fail(errorType, null);
    }


    public static Result fail(Object data) {
        return new Result<>(ErrorType.SYSTEM_ERROR, data);
    }


    @JsonIgnore
    public boolean isSuccess() {
        return SUCCESSFUL_CODE.equals(this.code);
    }


    @JsonIgnore
    public boolean isFail() {
        return !isSuccess();
    }
}
