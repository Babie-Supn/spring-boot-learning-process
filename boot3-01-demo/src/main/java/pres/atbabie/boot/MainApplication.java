package pres.atbabie.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动SpringBoot的主入口程序
 */
//主程序:pres.atbabie.boot
@SpringBootApplication(scanBasePackages = "pres.atbabie") //这是一个SpringBoot应用
//可以给SpringBootApplication标签加scanBasePackages属性，来指定扫描的路径
//或者单独使用 @ComponentScan("pres.atbabie") 来指定扫描的路径
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class,args);
    }
}
