package cn.springSecurity.springmvc.config;

import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
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
@EnableWebMvc
@ComponentScan(basePackages = "cn.springSecurity.springmvc",includeFilters = {@ComponentScan.Filter
        (type = FilterType.ANNOTATION,value = Controller.class)})
public class WebConfig implements WebMvcConfigurer {


    //视图解析器
    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
    //设置初始打开页面
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
    }
}
