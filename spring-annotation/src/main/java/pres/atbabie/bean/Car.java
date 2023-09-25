package pres.atbabie.bean;

import org.springframework.stereotype.Component;

@Component
public class Car {
    public Car() {
        System.out.println("Car被创建了....");
    }
    public void init(){
        System.out.println("car...进行初始化了");
    }
    public void destroy(){
        System.out.println("Car...被销毁了...");
    }
}
