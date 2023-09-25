package pres.atbabie.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pres.atbabie.dao.BookDAO;

/**
 * 自动装配:
 *       Spring利用依赖注入（DI），完成对IOC容器中各个组件的依赖赋值
 *
 * 1）@Autowired:自动注入
 *            ①默认优先按照类型去容器找对应的组件，找到就赋值
 *            ②如果找到多个相同类型的组件，再将属性名称作为组件的id去容器中查找
 *            ③或者使用 @qualifier("xxx") 明确指出要装配的id
 *            ④自动装配默认一定要将属性赋值好，没有就会报错
 *            ⑤可以使用@Autowired(required = false) 来调整该组件是否必须
 *            ⑥@primary：让spring进行自动装配的时候，默认使用首选的bean
 *                        也可以继续使用@qualifier指定需要装配的bean名字
 *           BookService {
 *     @Autowired
 *     private BookDAO bookDAO;
 *     }
 *
 * 2）Spring还支持使用@Resource（JSR250)和@Inject(JSR330)【java规范的注解】
 *     @Resource：
 *              可以和@Autowired一样实现自动装配功能；默认是按照组件名称进行装配的；
 *              没有支持@Primary功能，也没有@Autowired（required=false）；
 *     @Inject ：
 *              需要导入javax.inject包，和Autowired功能一样，但没有required=false的功能：
 *
 * @Autowired是Spring定义的
 *
 * @Resource、@Inject是Java规范的，可以脱离Spring框架
 *
 * 3）@Autowired：构造器、参数、方法、属性；都是从容器中获取参数组件的值
 *              ①可以标注在方法上：@Bean +方法参数时：参数默认从容器中获取；默认不写@Autowired,效果都是一样的，可以自动装配
 *              ②可以标在构造器上：如果组件只有一个有参构造器，这个有参构造器的@Autoewired可以省略，参数位置的组件还是能自动从容器中获取
 *              ③可以放在参数位置：
 *
 * 4）自定义组件要使用Spring容器底层的一些组件（ApplicationContext,BeanFactory,xxx);
 *              自定义组件实现xxxAware：在创建对象的时候，会调用接口规定的方法注入相关组件；Aware
 *              把Spring底层一些组件注入到自定义的Bean中
 *              xxxAware：功能使用xxxProcessor实现；
 *                        ApplicationContextAware ===>ApplicationContextAwareProcessor;
 *
 *
 */
@ComponentScan({"pres.atbabie.service","pres.atbabie.controller","pres.atbabie.dao","pres.atbabie.bean"})
@Configuration
public class MainConfigofAutowired {

//    @Bean
//    public BookDAO bookDAO(){
//        BookDAO bookDAO = new BookDAO();
//        bookDAO.setLabel("2");
//        return bookDAO;
//    }


}
