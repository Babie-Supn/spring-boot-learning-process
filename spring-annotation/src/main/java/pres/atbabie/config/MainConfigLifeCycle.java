package pres.atbabie.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pres.atbabie.bean.Car;

/**
 * bean的生命周期
 *       bean创建 ---> 初始化 ---> 销毁
 * 容器管理bean的生命周期；
 * 我们可以自定义初始化和销毁的方法，容器在bean进行到当前生命周期的时候，就会来调用我们自定义的初始化和销毁方法
 *
 * 构造（对象创建）
 *     单实例：在容器启动时创建对象
 *     多实例：在获取时才创建
 *   postProcessBeforeInitialization：在初始化之前工作
 *初始化：
 *     对象创建完成，并赋好值，才初始化
 *   postProcessAfterInitialization：在初始化之后工作
 *销毁：
 *     单实例时：容器关闭时销毁
 *     多实例时：容器不会管理这个bean，容器不会调用销毁方法
 *
 * 遍历得到容器中所有的BeanPostProcess：挨个执行beforeInitialization
 * 一旦返回null，跳出for循环，不会执行后面的BeanPostProcessor.postProcessors
 *
 *      1）指定初始化和销毁方法
 *            通过@Bean指定 init-method  和 destroy-method；
 *      2）通过Bean实现InitializingBean（定义初始化逻辑）
 *                   DisposableBean（定义销毁逻辑）
 *
 *      3)可以通过JSR250里的：
 *                     1.@PostConstruct:在bean创建完成并且属性赋值完成；执行初始化
 *                     2.@PreDestroy：在容器销毁bean之前通知我们进行清理工作
 *
 *      4)BeanPostProcessor【interface】：bean的后置处理器：
 *                     在bean初始化前后进行一些处理工作：
 *                     postProcessBeforeInitialization：在初始化之前工作
 *                     postProcessAfterInitialization：在初始化之后工作
 *
 * Spring底层对BeanPostProcess的使用:
 *                    bean赋值、注入其他组件、@Autowired、生命周期注解功能，@Async...
 *
 *
 */
@ComponentScan("pres.atbabie.bean")
@Configuration
public class MainConfigLifeCycle {

    @Bean(initMethod = "init",destroyMethod = "destroy")
    public Car car(){
        return new Car();
    }

}
