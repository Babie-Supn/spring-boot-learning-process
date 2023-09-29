国际化
---
   国际化的自动配置参照MessageSourceAutoConfiguration

实现步骤：
1. Spring Boot 在类路径根下查找messages资源绑定文件。文件名为：messages.properties
2. 多语言可以定义多个消息文件，命名为messages_区域代码.properties。如：
   a. messages.properties：默认
   b. messages_zh_CN.properties：中文环境
   c. messages_en_US.properties：英语环境
3. 在程序中可以自动注入 MessageSource组件，获取国际化的配置项值
4. 在页面中可以使用表达式  #{}获取国际化的配置项值

3.@Autowired  
   MessageSource messageSource;
