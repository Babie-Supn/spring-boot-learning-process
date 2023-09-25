package pres.atbabie.condition;

import org.springframework.beans.factory.FactoryBean;
import pres.atbabie.bean.Color;

public class ColorFactoryBean implements FactoryBean<Color>{

    //返回一个color对象，这个对象会添加到容器中
    @Override
    public Color getObject() throws Exception {
        System.out.println("ColorFactoryRun.....");
        return new Color();
    }

    //定义返回的类型
    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    @Override
    public boolean isSingleton(){
        //控制是否是单实例
        //true 就是单例  false 多实例，每次获取都会创建一个新的bean
        return true;
    }
}
