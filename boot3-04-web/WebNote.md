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












