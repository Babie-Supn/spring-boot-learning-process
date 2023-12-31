package pres.atbabie.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import pres.atbabie.bean.Person;

//使用@PropertySource的value读取外部配置文件的k/v保存到运行的环境变量中
//   加载完外部配置文件后使用${}取出配置文件的值
@PropertySource(value = {"classpath:person.properties"})
@Configuration
public class MainConfigofPropertyValues {

    @Bean
    public Person person(){
        return new Person();
    }
}
