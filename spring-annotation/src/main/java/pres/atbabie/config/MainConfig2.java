package pres.atbabie.config;

import org.springframework.context.annotation.*;
import pres.atbabie.bean.Color;
import pres.atbabie.bean.Person;
import pres.atbabie.condition.*;

@Configuration
@Import({Color.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
/**
 * @Import导入组件，id默认是组件的全类名
 */

public class MainConfig2 {


    //Bean默认是单实例的

    /**
     * scope调整作用域
     * scope可以取：
     *       prototype:多实例的
     *                 多实例时：ioc容器启动时，并不会调用方法创建对象放在容器中，
     *                         而是每次获取的时候，才会调用方法，创建对象，每次创建对象，都会调一次方法
     *       singleton：单实例的，默认单实例
     *                  单实例时：ioc容器启动会调用方法创建对象放到ioc容器中
     *                          以后每次获取都是直接从容器（map.get())中拿
     *
     * Web条件下可以取：
     *       request:同一次请求，创建一个实例
     *       session:同一个session创建一个实例
     *
     * 懒加载：
     *      针对单实例的bean，因为默认容器在启动的时候创建对象；
     *      而懒加载即：让其在ioc容器启动的时候不创建对象。而在第一次使用（获取）Bean的时候创建对象，并进行初始化
     *
     */
//    @Scope("prototype")
    @Lazy
    @Bean("person")
    public Person person(){
        System.out.println("给容器中添加Person...");
        return new Person("kate",18);
    }

    /**
     * @Conditional : 按照一定的条件进行判断，满足条件给容器中注册bean
     *
     * 如果系统是windows,给容器注册（“bill”）
     * 如果是linux系统，给容器中注册（“Linus”）
     *
     * 放在类前，就是一个大前提，只有当满足当前条件，这个类中的配置的所以bean注册才能生效
     *
     */
    @Conditional({WindowsCondition.class})
    @Bean("bill")
    public Person person01(){
        return new Person("Bill",30);

    }

    @Conditional({LinuxCondition.class})
    @Bean("linus")
    public Person person02(){
        return new Person("linus",33);
    }

    /**
     * 给容器中注册组件：
     *   1）包扫描+组件标注注解（@Controller、@Service、@Repository、@Component
     *   2）@Bean[导入第三方包里面的组件]
     *   3）@Import[快速给容器中导入一个组件]
     *                    1)@Import导入组件，id默认是组件的全类名
     *                    2）ImportSelector：返回需要导入的组件的全类名数组
     *                    3)ImportBeanDefinitionRegistrar:手动注册bean到容器中
     *  4）使用Spring提供的FactoryBean（工厂Bean）
     *                    1）默认获取到的是工厂bean调用getObject创建的对象
     *                    2）若要获取工厂bean本身，那么在id前面加 & 标识
     *
     */

    @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }

}
