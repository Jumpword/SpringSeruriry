package cn.springSecurity.springmvc.web;

import cn.springSecurity.springmvc.model.AuthenticationRequest;
import cn.springSecurity.springmvc.model.UserDto;
import cn.springSecurity.springmvc.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @Author jumping-張文平
 * @Date 2019/11/19 23:59
 * @Version 1.0
 */
@RestController
public class LoginController {
    @Autowired
    AuthenticationService authenticationService;
    @RequestMapping(value = "/login",produces = "text/plain;charset=utf-8")
    public String login(AuthenticationRequest authenticationRequest, HttpSession session){
        UserDto userDto = authenticationService.authentication(authenticationRequest);
        //存入session
        session.setAttribute(UserDto.SESSION_USER_KEY,userDto);
        return userDto.getUsername()+"登录成功";
    }
}
