package pres.atbabie.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class LinuxCondition implements Condition {
    /**
     * ConditionContext:判断条件能使用的上下文（环境）
     * AnnotatedTypeMetadata：注释信息
     *
     * @param context
     * @param metadata
     * @return
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //是否linux系统
        //1.能获取到ioc使用的beanfactory
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        //2.能获取到类加载器
        ClassLoader classLoader = context.getClassLoader();
        //3.也能直接获取到环境信息，例 系统、运行时的信息、环境变量、虚拟机的信息
        Environment environment = context.getEnvironment();
        String property = environment.getProperty("os.name");

        //4.获取到bean定义的注册类
        BeanDefinitionRegistry registry = context.getRegistry();
        //可以用 BeanDefinitionRegistry对象判断容器中是否有对应Bean
        boolean person = registry.containsBeanDefinition("person");
        if(property.contains("Linux")){
            return true;
        }
        return false;
    }
}
