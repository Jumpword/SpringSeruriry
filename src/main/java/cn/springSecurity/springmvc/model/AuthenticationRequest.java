package cn.springSecurity.springmvc.model;

import lombok.Data;

/**
 * @Author jumping-張文平
 * @Date 2019/11/19 23:00
 * @Version 1.0
 */
@Data
public class AuthenticationRequest {
    //认证请求参数，账号、密码
    private String username;

    private String password;
}
