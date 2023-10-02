***MyBatis进行数据库映射***

---

1.使用 `@MapperScan` 告诉MyBatis，扫描哪个包下面的接口  
2.使用 `mybatis.mapper-locations` 告诉MyBatis，每个接口的xml文件在哪  
3.`MyBatis`就会自动关联绑定  

注意：
```
①接口的全类名要和mapper的xml的namespace 一一对应
②在进行数据库crud操作时，命名可能会和表中名字不同
       1.老办法，起别名
       2.如果是因为 _ 的驼峰式命名，那么可以开启：
                mybatis.configuration.map-underscore-to-camel-case=true
       3.         
```
SSM整合总结：
1. 导入` mybatis-spring-boot-starter`
2. 配置数据源信息  
    默认使用HikariDataSource数据源  
3. 配置mybatis的`mapper接口扫描`与`xml映射文件扫描`
4. 编写`bean`，`mapper`，生成xml，编写sql 进行crud。事务等操作依然和Spring中用法一样
5. 效果：  
   a. 所有sql写在xml中  
   b. 所有mybatis配置写在application.properties下面(以mybatis开头的) 


在调试模式里面（即debug开启）  
```
postive:生效的
Negative:不生效的
matched:匹配成功的
Did not match:匹配不成功的
Unconditional classes: 不成立的条件
Exclusions:排除的配置
```




