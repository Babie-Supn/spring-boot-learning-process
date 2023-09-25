package pres.atbabie.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 将后置处理器加入到容器中
 */
@Component
public class MyBeanPostProcess implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException{
        System.out.println(beanName+"初始化操作前工作");
        return bean;
    }
    @Override
    public  Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException{
        System.out.println(beanName+"初始化操作完成了 我工作咯");
        return bean;
    }
}
