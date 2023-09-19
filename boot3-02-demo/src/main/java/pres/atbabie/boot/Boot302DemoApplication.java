package pres.atbabie.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Boot302DemoApplication {

    public static void main(String[] args) {
        //java10:局部变量类型的自动推断
        var ioc = SpringApplication.run(Boot302DemoApplication.class, args);
        //1.获取容器中所有组件的名字
        String[] names= ioc.getBeanDefinitionNames();
        //2.挨个遍历
        //DispatcherServlet、ViewResolver...
        //SpringBoot把以前配置的核心组件现在都给我们自动配置好了
        for (String name : names) {
            System.out.println(name);
        }


    }

}
