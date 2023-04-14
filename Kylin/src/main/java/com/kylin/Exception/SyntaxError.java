package com.kylin.Exception;

import java.util.Date;

public class SyntaxError {
    private String message;
    private String time;
    private String file;

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTime() {
        Date date = new Date(System.currentTimeMillis());
        this.time = String.valueOf(date.getTime());
    }

    public void setFile(String path) {
        this.file = path;
    }

    public String getError() {
        return "kylin.exception.SyntaxError: "+message+"\nTime: "+time+"\nPath: "+file;
    }
}
