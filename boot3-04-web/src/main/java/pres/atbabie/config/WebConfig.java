package pres.atbabie.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 */
//全面接管SpringMvc
//@EnableWebMvc   //禁用mvc的默认功能
@Configuration
public class WebConfig implements WebMvcConfigurer {

}
