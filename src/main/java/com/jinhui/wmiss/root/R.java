package com.jinhui.wmiss.root;

import lombok.Data;

import java.io.Serializable;

@Data
public class R<T> implements Serializable {
    private int statusCode;
    private T data;

    public R(int statusCode) {
        this.statusCode = statusCode;
    }

    public static R ok() {
        return new R<>(200);
    }
    public static <T> R ok(T data) {
        R res = ok();
        res.setData(data);
        return res;
    }

}
