package cn.security.springboot.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author jumping-張文平
 * @Date 2019/11/20 15:04
 * @Version 1.0
 */
@RestController
public class LoginController {

    @RequestMapping(value = "/login-success",produces = {"text/plain;charset=UTF-8"})
    public String loginSuccess(){
        return "登录成功";
    }

    @RequestMapping(value = "/r/r1",produces = {"text/plain;charset=UTF-8"})
    public String r1(){
        return "访问资源1";
    }
}
