package pres.atbabie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pres.atbabie.converter.MyYamlMessageConverter;

import java.util.List;
import java.util.concurrent.TimeUnit;

//手自一体 这样就可以有多种访问路径  如果只想要手动 加 @EnableWebMvc  标签禁用boot默认配置
@Configuration  //也可以就给容器中放一个WebMvcConfigurer组件，就可以自定义
public class MyConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //保留以前的默认配置，不用static前缀也可以访问 当然下面的注释掉也可以生效
//        WebMvcConfigurer.super.addResourceHandlers(registry);
        //自己写，
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/","classpath:/public/")
                .setCacheControl(CacheControl.maxAge(1180, TimeUnit.SECONDS));
    }
//    @Bean
//    public WebMvcConfigurer webMvcConfigurer(){
//        return new WebMvcConfigurer() {
//            @Override
//            public void addResourceHandlers(ResourceHandlerRegistry registry) {
//                WebMvcConfigurer.super.addResourceHandlers(registry);
//            }
//        };


    @Override  //配置一个能把对象转化为yaml格式的消息转换器
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new MyYamlMessageConverter());
    }
}



