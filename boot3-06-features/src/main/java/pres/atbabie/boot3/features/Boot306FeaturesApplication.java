package pres.atbabie.boot3.features;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * 1.标识环境
 * 2.切换环境
 */
@SpringBootApplication
public class Boot306FeaturesApplication {

    public static void main(String[] args) {
        //1.SpringApplication：Boot应用的核心API入口
//        SpringApplication.run(Boot306FeaturesApplication.class, args); //这一行可以拆解为：

        //1.自定义SpringApplication的底层设置
//        SpringApplication application = new SpringApplication(Boot306FeaturesApplication.class);
//        //这样就可以调整SpringApplication一些的参数
////        但是在这里的配置优先级低于配置文件中配置的
////        application.setDefaultProperties();
//        //2.SpringApplication 运行起来
//        application.run(args);

        //2.通过builder的方式,通过 fluentBuilder API设置
        new SpringApplicationBuilder()
                .main(Boot306FeaturesApplication.class)
                .bannerMode(Banner.Mode.CONSOLE)
                .properties("server.port=8080")//所有的配置项也可以在这里配置
                .run(args);

    }

}
