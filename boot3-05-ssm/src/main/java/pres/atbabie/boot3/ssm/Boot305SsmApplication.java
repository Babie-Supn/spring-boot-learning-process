package pres.atbabie.boot3.ssm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1.使用 @MapperScan 【批量扫描】告诉MyBatis，扫描哪个包下面的接口
 * 2.使用 mybatis.mapper-locations 告诉MyBatis，每个接口的xml文件在哪
 * 3.MyBatis就会自动关联绑定
 */
@MapperScan(basePackages = "pres.atbabie.boot3.ssm.mapper")
@SpringBootApplication
public class Boot305SsmApplication {

    public static void main(String[] args) {
        SpringApplication.run(Boot305SsmApplication.class, args);
    }

}
