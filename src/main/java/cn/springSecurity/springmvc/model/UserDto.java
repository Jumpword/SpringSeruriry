package cn.springSecurity.springmvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author jumping-張文平
 * @Date 2019/11/19 23:03
 * @Version 1.0
 */
@Data
@AllArgsConstructor
public class UserDto {
    public static final String SESSION_USER_KEY = "_user";
    private String id;
    private String username;
    private String password;
    private String fullname;
    private String mobile;
}
