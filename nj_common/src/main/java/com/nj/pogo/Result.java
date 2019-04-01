package com.nj.pogo;

import java.util.Date;

/**
 * @Author 牛杰
 * @Date 2019/2/26 10:57
 * @ClassName:Result
 */
public class Result {
    private String time;
    private Date date;

    public Result(String time, Date date) {
        this.time = time;
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
