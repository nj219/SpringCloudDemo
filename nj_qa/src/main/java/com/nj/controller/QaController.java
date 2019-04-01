package com.nj.controller;

import com.nj.client.BaseClient;
import com.nj.pogo.Result;
import com.nj.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @Author 牛杰
 * @Date 2019/2/26 9:32
 * @ClassName:QaController
 */
@RestController
@CrossOrigin
@RequestMapping("qa")
public class QaController {
    @Autowired
    private BaseClient baseClient;

    @GetMapping
    public String getMessage() {
        return "这是qa模块";
    }

    @GetMapping("time")
    public Result getBaseTime() {
        Result result = baseClient.getTime(System.currentTimeMillis() + "", new Date());
        return result;
    }

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("token")
    public String parseToken() {
        return "登陆成功";
    }
}
