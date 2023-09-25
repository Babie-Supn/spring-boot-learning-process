package pres.atbabie.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import pres.atbabie.bean.Person;

//配置类 == 配置文件 就相当于注册容器组件的xml
@Configuration
@ComponentScan(value = "pres.atbabie",includeFilters ={
//        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes ={
//                Controller.class, Service.class
//        })
        @ComponentScan.Filter(type = FilterType.CUSTOM,classes = {MyTypeFilter.class})
},useDefaultFilters = false)
/**
 * value :指定要扫描的包
 * excludeFilters :指定要排除扫描的组件，是一个数组
 *                 在Filter里选择要排除的类型
 *                 FilterType.ANNOTATION 是按照标签排除
 *                 FilterType.ASSIGNABLE_TYPE：按照给定的类型
 *                 FilterType.ASPECTJ:使用ASPECTJ表达式
 *                 FilterType.REGEX：使用正则表达式
 *                 FilterType.CUSTOM：使用自定义规则 需要写一个 TypeFilter 的实现类
 *
 * includeFilters :指定扫描的时候只需要包含哪些组件，也是一个数组
 *                 但是需要先禁用默认扫描规则
 *
 *@ComponentScans 里面的value值是一个数组可以用来包含多个@ComponentScan规则
 */
public class MainConfig {

    //即之前bean id="?" ?默认等于这里的方法名
    @Bean
    public Person person(){
        return new Person("余舒萍",20);
    }
}
