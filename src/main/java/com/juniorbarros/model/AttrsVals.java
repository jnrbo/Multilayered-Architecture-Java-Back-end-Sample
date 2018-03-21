package com.juniorbarros.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by juniorbarros on 03/08/2017.
 */
public class AttrsVals {

    private List<AttrVal> list;

    public AttrsVals() {
        list = new ArrayList<>();
    }

    public AttrsVals add(String attribute, Object value) {
        list.add(new AttrVal(attribute, value));
        return this;
    }

    public List<AttrVal> getList() {
        return list;
    }
}