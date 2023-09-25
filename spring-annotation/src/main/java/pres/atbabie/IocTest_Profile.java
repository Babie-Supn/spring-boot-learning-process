package pres.atbabie;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pres.atbabie.config.MainConfigofProfile;

import javax.sql.DataSource;

/**
 * 使用代码方式
 *      ①创建一个applicationContext
 *      ②设置需要激活的环境
 *      ③注册主配置类
 *      ④启动刷新容器
 */

public class IocTest_Profile {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext();
        ioc.getEnvironment().setActiveProfiles("test");
        ioc.register(MainConfigofProfile.class);
        ioc.refresh();
        for (String s : ioc.getBeanNamesForType(DataSource.class)) {
            System.out.println(s);
        }


        ioc.close();

    }
}
