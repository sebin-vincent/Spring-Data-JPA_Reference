package com.example.jpa_practice.dto;

public class ResponseDto {

    public ResponseDto() {

    }

    public ResponseDto(Object payload) {
        this.payload = payload;
    }



    private Object payload;

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }
}
