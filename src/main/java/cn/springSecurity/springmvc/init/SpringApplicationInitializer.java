package cn.springSecurity.springmvc.init;

import cn.springSecurity.springmvc.config.ApplicationConfig;
import cn.springSecurity.springmvc.config.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @Author jumping-張文平
 * @Date 2019/11/19 21:39
 * @Version 1.0
 * 加载spring容器 就是初始化配置信息
 */
public class SpringApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{ApplicationConfig.class};//指定rootContext的配置类 applicationContext配置类
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};//指定servletContext的配置类  SpringMvc配置类
    }


    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};    //项目访问路径
    }
}
