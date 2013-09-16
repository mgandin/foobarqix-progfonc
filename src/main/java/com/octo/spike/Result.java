package com.octomga.foobarqix;

import java.util.Map;

public class Result {
    private Map<String,Object> values;


    public Map<String, Object> getValues() {
        return values;
    }

    public void setValues(Map<String, Object> values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return "Result{" +
                "values=" + values +
                '}';
    }
}
