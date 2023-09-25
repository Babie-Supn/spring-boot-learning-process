package pres.atbabie.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class Blue implements InitializingBean, DisposableBean {
    public Blue() {
        System.out.println("Blue被创建了");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Blue...被销毁了...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Blue...初始化了...");
    }
}
