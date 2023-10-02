Profiles
---

环境隔离能力；快速切换开发、测试、生产环境

标识组件环境在组件上用@Profiles("dev")等,也可以用大括号{}指定多个，标识  
默认环境为：`default`  

## **如果组件没有标注环境，那么任意环境下他都激活**

在类上标注@Profiles就是一个大前提  
激活环境：  
1.配置文件激活` spring.profiles.active=`,也可以一次激活多个  
2.使用命令行激活，在`edit configurations `里加一个`program arguments`,内容为`--spring.profiles.active=prod`  
当然也可以是其他的环境。命令行激活：`java -jar xxx.jar`

最佳实战：  
·生效的环境=`激活的环境/默认环境` +`包含环境`  
·项目里这么用：  
     基础的配置`mybatis`、`log`、`xxx`:写到包含环境中（include）  
     需要动态切换变化的`db`、`redis`：写到激活环境中（active）  
也可以先分组，用spring.profiles.group.`组名`=(可以是多个测试环境)  
这样再激活组名就可以了spring.profiles.active=`组名 `  


---

**配置文件怎么使用Profiles功能**  
1）、application.properties:主配置文件，任何情况下都生效  
2）其他profiles环境下命名规范：application-{profiles标识}.properties  
例如：application-dev.properties  
3）激活指定环境即可，配置文件激活、命令行激活  
4）效果：  
`项目的所有生效配置项` = `激活环境配置文件的所有项 `+ `主配置文件和激活文件不冲突的所有项`  
即如果发生了配置冲突，以激活的环境配置文件为准  
`spring.profiles.active` 和`spring.profiles.default `**只能用到 无 profile 的文件中，**  
**如果在application-dev.yaml中编写就是无效的**

以下是 SpringBoot 属性源加载顺序。后面的会覆盖前面的值。由低到高，高优先级配置覆盖低优先级
1. **默认属性**（通过SpringApplication.setDefaultProperties指定的）
2. @PropertySource指定加载的配置（需要写在@Configuration类上才可生效）
3. **配置文件**（application.properties/yml等）
4. RandomValuePropertySource支持的random.*配置（如：@Value("${random.int}")）
5. OS 环境变量
6. Java 系统属性（System.getProperties()）
7. JNDI 属性（来自java:comp/env）
8. ServletContext 初始化参数
9. ServletConfig 初始化参数
10. SPRING_APPLICATION_JSON属性（内置在环境变量或系统属性中的 JSON）
11. **命令行参数**
12. 测试属性。(@SpringBootTest进行测试时指定的属性)
13. 测试类@TestPropertySource注解
14. Devtools 设置的全局属性。($HOME/.config/spring-boot)

结论：配置可以写到很多地方，但常用的三种优先级是：`命令行参数`>`配置文件`>`默认属性（程序上写的）springApplication上的`

jar包内的小于jar包外的  
包外的就放在jar包同级就好    
包内的话：`classpath:/config/application.properties`>`classpath:/application.properties`  
即 `类路径下/config包` > `类根路径下`  
包外如果也有`config`文件夹，那么和包内也是一样的  
然后config里面有子包，那么优先级更高  
在终端命令行可以启动打包好的jar项目，指令为：`java -jar xxx.jar`  
当然如果要加配置项语句就是在后面再--  
举例为:`java -jar xx.jar --server.port=9000`  

规律：最外层的最优先。  
● 命令行 > 所有  
● 包外 > 包内  
● config目录 > 根目录  
● profile > application   
配置不同就都生效（部署），配置相同就高优先覆盖低优先  
配置文件里面也能用${}占位符，获取其他的配置的数据  
@Value 可以用来注入配置文件里的值

```java
@Value("${server.port}")
String port;//这样port就能拿到server.port的值

//也可以直接设置配置文件没有配置的值
@Value("${haha:你好}")
String haha;//这样也可以直接设置属性默认值
//当然配置文件的优先级大于程序里Value的
```


