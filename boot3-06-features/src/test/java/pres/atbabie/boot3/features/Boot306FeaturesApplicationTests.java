package pres.atbabie.boot3.features;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pres.atbabie.boot3.features.service.HelloService;

//测试类也必须在主程序所在的包及其子包
@SpringBootTest //具备测试SpringBoot应用容器中所有组件的功能
class Boot306FeaturesApplicationTests {
    @Autowired//直接注入任意组件，来直接测试组件
    HelloService helloService;

    @DisplayName("测试1")
    @Test
    void contextLoads() {
        int add = helloService.add(3, 4);
        Assertions.assertEquals(7,add);
    }

    @DisplayName("测试2")
    @Test
    void test01(){
        System.out.println("aaaa");
    }

}
