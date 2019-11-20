package cn.security.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @Author jumping-張文平
 * @Date 2019/11/19 20:53
 * @Version 1.0
 * 相当于以前的servletContext
 * 对应DispatcherServlet配置
 */
@Configuration//相当于springmvc.xml文件
public class WebConfig implements WebMvcConfigurer {

    //默认url根据路径转到/login，此url是spring security提供
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("registry:/login");
    }
}
