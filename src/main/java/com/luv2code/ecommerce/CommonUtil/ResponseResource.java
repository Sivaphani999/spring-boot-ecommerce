package com.luv2code.ecommerce.CommonUtil;


import java.util.UUID;

public class ResponseResource<T> {
    public static final String R_MSG_EMPTY = "";

    public static final Integer R_CODE_OK = 0;

    public static final Integer R_CODE_ERROR = 1;

    private final Integer responseCode;

    public Integer getResponseCode() {
        return this.responseCode;
    }

    public String getMessage() {
        return this.message;
    }

    public String getTraceId() {
        return traceId;
    }

    public T getData() {
        return this.data;
    }

    private final String message;

    private final String traceId;

    private T data;

    public void setData(T data){
        this.data = data;
    }

    public ResponseResource(){
        this.message = R_MSG_EMPTY;
        this.responseCode = R_CODE_OK;
        this.setData(data);
        this.traceId = UUID.randomUUID().toString();
    }

    public ResponseResource(T data){
        this.message = R_MSG_EMPTY;
        this.responseCode = R_CODE_OK;
        this.setData(data);
        this.traceId = UUID.randomUUID().toString();
    }
    public ResponseResource(String message, Integer responseCode){
        this.message= message == null ? R_MSG_EMPTY : message;
        this.responseCode= responseCode == null ? R_CODE_OK : responseCode;
        this.traceId = UUID.randomUUID().toString();
    }

    public ResponseResource(String message, Integer responseCode, T data){
        this.message = message == null ? R_MSG_EMPTY : message;
        this.responseCode = responseCode == null ? R_CODE_OK : responseCode;
        this.setData(data);
        this.traceId = UUID.randomUUID().toString();
    }

    public ResponseResource(String message, Integer responseCode, T data, String traceId){
        this.message = message;
        this.responseCode = responseCode;
        this.setData(data);
        this.traceId = traceId;
    }
}
