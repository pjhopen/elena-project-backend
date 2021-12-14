package com.oakhill.elena.model;

import org.springframework.http.HttpStatus;

/**
 * Return object to frontend
 */
public class ReturnData<T> {
    private int status;
    private String message;
    private T data;
    private long timestamp;

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public ReturnData() {
        this.timestamp = System.currentTimeMillis();
    }

    public static <T> ReturnData<T> success(T data) {
        ReturnData<T> ReturnData = new ReturnData<>();
        ReturnData.setStatus(HttpStatus.OK.value());
        ReturnData.setMessage(HttpStatus.OK.getReasonPhrase());
        ReturnData.setData(data);
        return ReturnData;
    }

    public static <t> ReturnData<t> fail(HttpStatus status) {
        ReturnData<t> ReturnData = new ReturnData<>();
        ReturnData.setStatus(status.value());
        ReturnData.setMessage(status.getReasonPhrase());
        return ReturnData;
    }
}
