package pres.atbabie.boot.config;


import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;
import pres.atbabie.boot.bean.Cat;
import pres.atbabie.boot.bean.Dog;
import pres.atbabie.boot.bean.User;

/**
 *
 */
@ConditionalOnClass(name="com.alibaba.druid.FastsqlException")//放在类级别，单独对这个方法进行注解判断
@SpringBootConfiguration
public class AppConfig2 {

    @ConditionalOnClass(name="com.alibaba.druid.FastsqlException")//放在方法级别，单独对这个方法进行注解判断
    @Bean
    public Cat cat(){
        return new Cat();
    }

    @ConditionalOnMissingClass(value="com.alibaba.druid.FastsqlException")
    @Bean
    public Dog dog(){
        return new Dog();
    }

    @ConditionalOnBean(value= Dog.class)
    @Bean
    public User chenyile(){
        return new User();
    }

    @ConditionalOnMissingBean(value = Dog.class)
    @Bean
    public User chenyileshagou(){
        return new User();
    }



}
