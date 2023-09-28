package pres.atbabie.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//@EnableWebMvc加这个就是全手动
//不加就是手自一体
@Configuration
public class TestConfig implements WebMvcConfigurer {
}
