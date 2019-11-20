package cn.springSecurity.springmvc.service;

import cn.springSecurity.springmvc.model.AuthenticationRequest;
import cn.springSecurity.springmvc.model.UserDto;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author jumping-張文平
 * @Date 2019/11/19 23:11
 * @Version 1.0
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {


    /**
     * 用户认证 校验用户的身份信息是否合法
     * @param authenticationRequest 用户认证请求，账号和密码
     * @data 2019/11/19 23:12
     *
     * @return 认证成功的用户信息
     */
    @Override
    public UserDto authentication(AuthenticationRequest authenticationRequest) {
        if(authenticationRequest==null|| StringUtils.isEmpty(authenticationRequest.getUsername())
                ||StringUtils.isEmpty(authenticationRequest.getPassword())
        ){
            throw new RuntimeException("账号或密码为空");
        }
        UserDto userDto = getUserDto(authenticationRequest.getUsername());
        if(userDto==null){
            throw new RuntimeException("查询不到该用户");
        }
        if(!authenticationRequest.getPassword().equals(userDto.getPassword())){
            throw new RuntimeException("账户或密码错误");
        }
        return userDto;
    }


    //模拟用户查询
    public UserDto getUserDto(String username){
        return userMap.get(username);
    }
    //用户信息
    private Map<String,UserDto> userMap = new HashMap<>();
    {
        userMap.put("zhangsan",new UserDto("1010","zhangsan","123","张三","133443"));
        userMap.put("lisi",new UserDto("1011","lisi","456","李四","144553"));

    }
}
