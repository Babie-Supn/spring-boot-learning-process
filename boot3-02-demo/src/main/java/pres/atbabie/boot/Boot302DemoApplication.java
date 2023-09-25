package pres.atbabie.boot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pres.atbabie.boot.bean.*;


@SpringBootApplication
public class Boot302DemoApplication {

    public static void main(String[] args) {
        //java10:局部变量类型的自动推断
        var ioc = SpringApplication.run(Boot302DemoApplication.class, args);
        //1.获取容器中所有组件的名字
//        String[] names= ioc.getBeanDefinitionNames();
//        //2.挨个遍历
//        //DispatcherServlet、ViewResolver...
//        //SpringBoot把以前配置的核心组件现在都给我们自动配置好了
//        for (String name : names) {
//            System.out.println(name);
//        }

//        String[] forType = ioc.getBeanNamesForType(FastsqlException.class);
//        for(String s:forType){
//            System.out.println(s);
//        }
//        Object user01 = ioc.getBean("user01");
//       Object user02= ioc.getBean("user01");
//        System.out.println(user01==user02);

//        for (String s : ioc.getBeanNamesForType(Cat.class)) {
//            System.out.println("cat:"+s);
//        }
//        for (String s : ioc.getBeanNamesForType(Dog.class)) {
//            System.out.println("dog:"+s);
//        }
//        for (String s : ioc.getBeanNamesForType(User.class)) {
//            System.out.println("user:"+s);
//        }
//
//
//        Cat cat=ioc.getBean(Cat.class);
//        System.out.println("cat:"+cat);
//
//        Sheep sheep = ioc.getBean(Sheep.class);
//        System.out.println(sheep);
        Person bean = ioc.getBean(Person.class);
        System.out.println(bean);


    }

}
