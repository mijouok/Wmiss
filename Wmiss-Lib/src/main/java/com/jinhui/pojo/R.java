package com.jinhui.pojo;

import lombok.Data;

/**
 * DESCRIPTION_OF_YOUR_CLASS
 *
 * @author zhoumi (mizhouok@gmail.com)
 */
@Data
public class R<X> implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    private X data;
    private int code; // 200/500
    private String msg;
    public R(X data, int code, String msg) {
        this.data = data;
        this.code = code;
        this.msg = msg;
    }
    public R(X data) {
        this.data = (X) data;
    }
    public R(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public static R ok() {
        return new R(200, null);
    }
    public R(int code, X data) {
        this.code = code;
        this.data = data;
    }
    public static <X> R ok(X data) {
        return new R(200, data);
    }
    public static R error(String msg) {
        return new R(500, msg);
    }
}
