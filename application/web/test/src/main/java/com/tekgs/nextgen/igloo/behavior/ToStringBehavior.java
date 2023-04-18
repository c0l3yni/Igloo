package com.tekgs.nextgen.igloo.behavior;

import com.google.gson.Gson;

public class ToStringBehavior {
    private final Object forToString;

    public ToStringBehavior(Object forToString) {
        this.forToString = forToString;
    }

    public static ToStringBehavior getInstance(Object forToString) {
        return new ToStringBehavior(forToString);
    }

    public String execute() {
        return String.format("%s: %s", forToString.getClass().getSimpleName(), new Gson().toJson(forToString));
    }
}
