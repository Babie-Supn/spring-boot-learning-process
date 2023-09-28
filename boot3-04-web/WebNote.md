---
静态资源
---
静态资默认放在\
"classpath:/META-INF/resources/\"
"classpath:/resources/"\
"classpath:/static/"\
"classpath:/public/"\
---
静态资源有默认的缓存规则\
cachePeriod:缓存周期，多久不用找服务器更新 默认值为0，\
cacheControl:HTTP缓存控制\
useLastModified:是否使用最后一次修改，配合HTTP cache规则

---
HandlerMapping:根据请求路径 /xx 找哪个handler能处理请求\

---
Favicon:一个隐形规则\
       可以给网页设置图标\
      `favicon.ico` \
在这个静态资源里，boot只是提供了一个规则
---
状态码如果是304：\
   代表最后一次修改时间一致，可以用缓存，不需向服务器请求

---
`spring.mvc`:静态资源访问的前缀路径\
`spring.web`:静态资源目录
   ---
SpringBoot多端内容适配  
1.1基于请求头内容协商 是默认开启的  
  Accept: /json /xml /yaml ...  
  服务器端根据客户端请求头的数据类型进行动态返回  
1.2 基于请求参数内容协商 （需要手动开启）  
spring.mvc.contentnegotiation.favor-parameter=true  
#修改请求参数的内容协商的参数 修改为type
spring.mvc.contentnegotiation.parameter-name=type  
`HttpMessageConverter`:内容协商原理  
  ·编写 `WebMvcConfigurer` 提供的 `configureMessageConverter`底层方法，修改底层的MessageConverter  
 

1.如果controller方法的返回值标注了 @ResponseBody 注解
   1.1. 请求进来先来到DispatcherServlet的doDispatch()进行处理  
   1.2. 找到一个 HandlerAdapter 适配器。利用适配器执行目标方法  
   1.3. RequestMappingHandlerAdapter来执行，调用`invokeHandlerMethod（）`来执行目标方法  
   1.4. 目标方法执行之前，准备好两个东西  
   1.4.1. `HandlerMethodArgumentResolver`：参数解析器，确定目标方法每个参数值  
   1.4.2.` HandlerMethodReturnValueHandler`：返回值处理器，确定目标方法的返回值改怎么处理  
   1.5. `RequestMappingHandlerAdapter` 里面的`invokeAndHandle()`真正执行目标方法  
   1.6. 目标方法执行完成，会返回返回值对象  
   1.7. 找到一个合适的返回值处理器 `HandlerMethodReturnValueHandler  `
   1.8. 最终找到` RequestResponseBodyMethodProcessor`能处理 标注了` @ResponseBody`注解的方法  
   1.9. `RequestResponseBodyMethodProcessor `调用`writeWithMessageConverters `,利用`MessageConverter`把返回值写出去  
以上解释了：`@ResponseBody`由`HttpMessageConverter`处理  
· 先进行内容协商，查看客户期望的最终类型 类json/xml/html...  
 a-遍历所有的`MessageConverter`看谁支持这种内容类型的数据  
 b-默认的`MessageConverter`（消息转换器）有8种  可以添加对应的依赖包，而添加更多内容协商功能
 c-
  










`406`:代表内容适配不了  













