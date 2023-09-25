package pres.atbabie.condition;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import pres.atbabie.bean.RainBow;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     * AnnotationMetadata:获取当前类的注解信息
     * BeanDefinitionRegistry：BeanDefinition注册类；
     *                        把所有需要添加到容器中的bean；
     *                        BeanDefinitionRegistry.registerBeanDefinitions手工注册进来
     *
     * @param importingClassMetadata
     * @param registry
     * @param importBeanNameGenerator
     */
    @Override
   public void  registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry, BeanNameGenerator importBeanNameGenerator){
        //registry.containsBeanDefinition:判断是否有该名字的组件
        boolean blue = registry.containsBeanDefinition("pres.atbabie.bean.Blue");
        if(blue){
            //指定bean的定义信息：（Bean的类型，Bean）
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(RainBow.class);
            //注册一个Bean，指定Bean名
            registry.registerBeanDefinition("rainBow",rootBeanDefinition);



        }

    }
}
