package cn.springSecurity.springmvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @Author jumping-張文平
 * @Date 2019/11/19 19:47
 * @Version 1.0
 *
 * 对应web.xml ContextLoaderListener的配置
 * 不扫描Controller注解
 */
@Configuration //相当于applicationContext.xml
@ComponentScan(basePackages = "cn.springSecurity.springmvc",excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,value = Controller.class)})
public class ApplicationConfig {
    //此配置除了Controller的其它bean，比如：数据库连接池、事务管理器、业务bean等。

}
