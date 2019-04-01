package com.nj.controller;

import com.nj.pogo.Result;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @Author 牛杰
 * @Date 2019/2/26 9:27
 * @ClassName:BaseController
 */
@RestController
@CrossOrigin
@RequestMapping("base")
public class BaseController {
    @GetMapping
    public String getMessage() {
        return "这是base模块";
    }

    @GetMapping("{time}/{date}")
    public Result getTime(@PathVariable String time, @PathVariable Date date) {
        return new Result(time,date);
    }
}
