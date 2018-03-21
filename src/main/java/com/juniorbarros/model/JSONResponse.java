package com.juniorbarros.model;

/**
 * Created by juniorbarros on 04/09/2017.
 */
public class JSONResponse {

    private Object data;

    public JSONResponse(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }
}
