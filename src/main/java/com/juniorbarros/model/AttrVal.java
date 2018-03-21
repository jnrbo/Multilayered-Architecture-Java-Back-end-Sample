package com.juniorbarros.model;

/**
 * Created by juniorbarros on 03/05/2016.
 */
public class AttrVal {
    private String attribute;
    private Object value;

    public AttrVal(String attribute, Object value) {
        this.attribute = attribute;
        this.value = value;
    }

    public String getAttribute() {
        return attribute;
    }

    public Object getValue() {
        return value;
    }
}