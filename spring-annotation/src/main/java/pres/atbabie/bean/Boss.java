package pres.atbabie.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//默认加载ioc容器中的组件，容器启动会调用无参构造器，再进行初始化赋值等操作
@Component
public class Boss {

    private Car car;

    public Car getCar() {
        return car;
    }

    //构造器要用的组件，都是从容器中获取
    @Autowired
    public Boss(Car car) {
        this.car = car;
        System.out.println("Boss的有参构造器被调用了");
    }

//    @Autowired
    /**
     * 标注在方法，Spring容器创建当前对象就会调用方法，完成赋值
     * 方法使用的参数，自定义类型的值从ioc容器中获取
     */
    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "car=" + car +
                '}';
    }
}
