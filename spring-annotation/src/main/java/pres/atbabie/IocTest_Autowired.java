package pres.atbabie;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pres.atbabie.config.MainConfigofAutowired;
import pres.atbabie.dao.BookDAO;
import pres.atbabie.service.BookService;

public class IocTest_Autowired {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(MainConfigofAutowired.class);
        for (String name : ioc.getBeanDefinitionNames()) {
            System.out.println(name);

        }
        BookService bean = ioc.getBean(BookService.class);
        System.out.println(bean);
        BookDAO bean1 = ioc.getBean(BookDAO.class);

        System.out.println(bean1);

        System.out.println("这是测试的ioc容器："+ioc);
        ioc.close();
    }
}
