package cn.springSecurity.springmvc.service;

import cn.springSecurity.springmvc.model.AuthenticationRequest;
import cn.springSecurity.springmvc.model.UserDto;

/**
 * @Author jumping-張文平
 * @Date 2019/11/19 22:56
 * @Version 1.0
 */
public interface AuthenticationService {
   /**
    *
    * @param authenticationRequest
    * @data 2019/11/19 22:57
    *
    * @return
    */
   UserDto authentication(AuthenticationRequest authenticationRequest);
}
