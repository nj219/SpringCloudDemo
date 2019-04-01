package nj.user.controller;

import com.nj.util.JwtUtil;
import nj.user.client.BaseClient;
import nj.user.pojo.Teacher;
import nj.user.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author 牛杰
 * @Date 2019/2/26 9:34
 * @ClassName:UserController
 */
@RestController
@CrossOrigin
@RequestMapping("user")
public class UserController {
    @Autowired
    private BaseClient baseClient;

    @Autowired
    private TeacherService teacherService;

    @GetMapping
    public String getMessage() {
        String name = null;
        List<Teacher> all = teacherService.findAll();
        for (Teacher teacher : all) {
            name = teacher.getName();
        }
        return "这是user模块"+name;
    }

    @GetMapping("baseMessage")
    public String getBaseMessage() {
        return baseClient.getBaseMessage();
    }

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("login/{id}/{name}")
    public String login(@PathVariable String id, @PathVariable String name) {
        String token = jwtUtil.createToken(id, name, "user");
        return token;
    }
}
