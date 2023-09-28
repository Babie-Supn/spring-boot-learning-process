thymeleaf的一些基础语法
--- 
---
`getbootstrap.com`:网站里面有好多样式的样子

`xmlns:th="http://www.thymeleaf.org  `
在html里加这个，是为了可以看到提示  

```properties
指令格式：
th:text：替换标签体的内容,是什么内容就会显示什么内容    
th:utext：替换标签体的内容；不会转义html标签，会显示成html该有的格式  
th:属性(任意html属性):会动态替换任意属性的值  
th:attr:任意属性指定   
th:if：判断 th:if="(这里面的值类型要Boolean的，但是html的和js有关,或者在作用域传value值时，直接传boolean)"  
th:unless:相当于Java里的else
th:switch:相当于语言里的switch
th:case:同case
 但是要注意使用格式：
     th:case="'strings'"
这样来判断case里的字符串
th:其他指令：
  遍历
         th:each="元素名,迭代状态 :${集合}"
       iterStat(迭代状态）有以下属性：
          index：当前遍历元素的索引，从0开始 
          count：当前遍历元素的索引，从1开始
          size：需要遍历元素的总数量
          current：当前正在遍历的元素对象
          even/odd：是否偶数/奇数行
          first：是否第一个元素
           last：是否最后一个元素

```
attr用法展示：`th:attr="src=${url},style=${}..."`  

---

```properties
表达式：用来动态取值
${}:用来取model传进作用域的值，session传的也可以
@{}：专门用来动态取各种路径，加了@{}的路径会更安全，因为servlet.context-path这个项目根路径可能会有改变，而加了@{}后，thymeleaf会动态帮你封装路径
#{}：国际化消息
~{}：片段引用
*{}：变量选择：需要配合 th:object 绑定对象
    用法：<div th:object="${session.user}">
         <p>Name: <span th:text="*{firstName}">Sebastian</span>.</p>
         <p>Surname: <span th:text="*{lastName}">Pepper</span>.</p>
         <p>Nationality: <span th:text="*{nationality}">Saturn</span>.</p>
         </div>
      这样接下来要使用session.user对象的，只需要*{}
```
`th:src="@{${imgUrl}}"`：这种写法也是可以的  

---

```properties
系统工具&内置对象,但是只能在上面的一些表达式内用
对象：（有好多对象，列举一些应该常用的）
session:session对象
param:请求参数对象
application:application对象（内容对象要是把格式设为application，还会直接下载）
#uris:uri/url工具
#dates:日期工具
#calendars:类似#dates，只不过是java.util.Calendar对象的工具类
#strings:有对字符串的一些操作方法，像字符串长度，大小写转换
#objects:对象操作
#arrays：array工具
#ids：id生成工具
#maps...

```

---

文本拼串：如果不想老式拼串，那么一定要在外面加 |  |  
例如：要么`"${'前缀'+name+'后缀'}"`  
     要么：`"|前缀${name}后缀|"`  

---

Thymeleaf属性优先级:
 `片段`>`遍历`>`判断`  
片段：`th:insert`、` th:replace`  
遍历:`th:each`  
判断:`th:if`、`th:unless`、`th:switch`、`th:case`
 




