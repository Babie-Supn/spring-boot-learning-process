package pres.atbabie.boot.config;



import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Scope;
import pres.atbabie.boot.bean.Cat;
import pres.atbabie.boot.bean.Sheep;
import pres.atbabie.boot.bean.User;

/**
 *
 */
@EnableConfigurationProperties(Sheep.class)

/**
 * 1.开启sheep组件的属性绑定
 * 2.默认会把这个组件自己放到容器中
 * 3.一般用于导入第三方写好的组件，进行组件绑定
 *    因为SpringBoot 默认只扫描自己主程序所在的包，如果导入第三方包，即使组件上标注了@Component、@ConfigurationProperties 也没用
 *    因为组件都扫描不进来
 */

//@Import(FastsqlException.class)  //这样容器中放指定类型的组件，组件的名字默认是全类名
@SpringBootConfiguration //这是一个springboot配置类 在springboot项里自己写的一些配置类可以用这个
//@Configuration //告诉springboot这是一个普通配置类,替代以前的配置文件。 配置类本身也是容器中的组件 通用一点的配置类可以用这个
public class AppConfig {
    /**
     * 1.组件默认是单实例的
     * @return
     */
    @Scope("prototype")
    @Bean   //替代以前的bean标签 组件在容器中的名字默认是方法名 或者直接在Bean标签后加上
    public User user01(){
        var user = new User();
        user.setId(1L);
        user.setName("蛋蛋");
        return user;
    }
//    @Bean("catEgg")
//    public Cat cat(){
//        var cat=new Cat("蛋蛋",2);
//        return cat;
//    }

//    @Bean
//    public FastsqlException fastsqlException(){
//        return  new FastsqlException();
//    }

//    public Sheep sheep(){
//        return new Sheep();
//    }

}
