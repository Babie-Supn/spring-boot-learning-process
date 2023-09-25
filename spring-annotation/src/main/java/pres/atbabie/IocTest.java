package pres.atbabie;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pres.atbabie.bean.Person;
import pres.atbabie.config.MainConfigofPropertyValues;


public class IocTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(MainConfigofPropertyValues.class);
        System.out.println("ioc容器创建完成");
        for (String name : ioc.getBeanDefinitionNames()) {
            System.out.println(name);
        }
        System.out.println("==============");
        Person person = (Person) ioc.getBean("person");
        System.out.println(person);


        //关闭容器
        ioc.close();
        System.out.println("ioc容器被关闭了");

    }
}
