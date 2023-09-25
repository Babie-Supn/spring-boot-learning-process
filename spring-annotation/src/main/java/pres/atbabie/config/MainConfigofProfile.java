package pres.atbabie.config;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * Profile:
 *       Spring为我们提供的可以根据当前环境，动态的激活和切换一系列组件的功能；
 *
 * 开发环境、测试环境、生产环境
 * 数据源：（/A)、（/B）、（/C）；
 *
 * @Profile:指定组件在哪个环境的情况下才能被注册到容器中，不指定，任何环境下就都能注册到容器中
 *          1)加了环境标识的bean，那么就只有这个环境下，bean才会被注册到容器中，默认是default环境
 *          2）写在配置类上，表示只有是指定的环境的时候，整个配置类里面的所有配置才能开始生效
 *      Profile使用方法
 *            ①使用命令行动态参数：在虚拟机参数位置加载 -Dspring.profiles.active=dev/test/prod
 *            ②使用代码的形式去选择数据源环境
 *
 */
@PropertySource(value = {"classpath:c3p0.properties"})
@Configuration
public class MainConfigofProfile {
    @Value("${user}")
    private String user;
    @Value("${password}")
    private String password;
    @Value("${jdbcUrlTest}")
    private String jdbcUrlTest;
    @Value("${jdbcUrlDev}")
    private String jdbcUrlDev;
    @Value("${jdbcUrlProd}")
    private String jdbcUrlProd;
    @Value("${driverClass}")
    private String driverClass;

    @Profile("test")
    @Bean("testDataSource")
    public  DataSource dataSourceTest() throws PropertyVetoException {
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(password);
        dataSource.setJdbcUrl(jdbcUrlTest);
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }
    @Profile("dev")
    @Bean("devDataSource")
    public  DataSource dataSourceDev() throws PropertyVetoException {
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(password);
        dataSource.setJdbcUrl(jdbcUrlDev);
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }
    @Profile("prod")
    @Bean("prodDataSource")
    public  DataSource dataSourceProd() throws PropertyVetoException {
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(password);
        dataSource.setJdbcUrl(jdbcUrlProd);
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }
}
