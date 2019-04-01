package com.nj.client.impl;

import com.nj.client.BaseClient;
import com.nj.pogo.Result;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author 牛杰
 * @Date 2019/2/27 8:44
 * @ClassName:BaseClientImpl
 */
@Component
public class BaseClientImpl implements BaseClient {
    @Override
    public Result getTime(String time, Date date) {
        return new Result("连接异常",new Date());
    }
}
