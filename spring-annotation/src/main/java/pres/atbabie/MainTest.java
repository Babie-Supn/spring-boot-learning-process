package pres.atbabie;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import pres.atbabie.bean.Person;
import pres.atbabie.config.MainConfig;
import pres.atbabie.config.MainConfig2;

import java.util.Map;

public class MainTest {

    public static void main(String[] args) {
//        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(MainConfig.class);
//        Person person = ioc.getBean(Person.class);
//        System.out.println(person);
//
//        for (String s : ioc.getBeanNamesForType(Person.class)) {
//            System.out.println(s);
//        }
//        for (String name : ioc.getBeanDefinitionNames()) {
//            System.out.println(name);
//        }
        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(MainConfig2.class);
        ConfigurableEnvironment environment = ioc.getEnvironment();
        String property = environment.getProperty("os.name");
        System.out.println(property);
//        for (String name : ioc.getBeanDefinitionNames()) {
//            System.out.println(name);
//        }
//
//        System.out.println("ioc创建完毕");
//        Object person = ioc.getBean("bill");
//        Object person1 = ioc.getBean("person");
//
//        System.out.println(person);
//        System.out.println(person==person1);
        for (String s : ioc.getBeanNamesForType(Person.class)) {
            System.out.println(s);
        }
        for (String name : ioc.getBeanDefinitionNames()) {
            System.out.println("容器中有:"+name);
        }

        Map<String, Person> beansOfType = ioc.getBeansOfType(Person.class);
        System.out.println(beansOfType);

        //工厂Bean获取的是调用getObject创建的对象
//        Object colorFactoryBean = ioc.getBean("colorFactoryBean");
//        System.out.println("colorFactoryBean类型是:"+colorFactoryBean.getClass());


    }
}
