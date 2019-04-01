package com.nj.client;

import com.nj.client.impl.BaseClientImpl;
import com.nj.pogo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;

/**
 * @Author 牛杰
 * @Date 2019/2/26 10:29
 * @ClassName:BaseClient
 */
@FeignClient(value = "nj-base",fallback = BaseClientImpl.class)
public interface BaseClient {
    @GetMapping("base/{time}/{date}")
    Result getTime(@PathVariable String time, @PathVariable Date date);
}
