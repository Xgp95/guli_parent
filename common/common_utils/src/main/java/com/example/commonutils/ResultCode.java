package com.example.commonutils;

public interface ResultCode {

    public static Integer SUCCESS = 20000; //成功

    public static Integer ERROR = 20001; //失败
}
//public enum ResultCode {
//    SUCCESS(20000, "请求成功"),
//
//    ERROR(20001, "服务器错误");
//
//    private int code;
//    private String message;
//
//    ResultCode(int code, String message) {
//        this.code = code;
//        this.message = message;
//    }
//
//    public int getCode() {
//        return code;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//}
