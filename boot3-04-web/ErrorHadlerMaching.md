Spring底层给我们准备了默认机制  
---
这里记录错误处理机制，不再怕报错  
**错误处理的自动配置**都在`ErrorMvcAutoConfiguration`中，两大核心机制：  
·1.SpringBoot会自适应处理错误，响应页面或JSON数据  
·2.SpringMVC的错误处理机制依然保留，MVC处理不了，才会交给boot进行处理  

SpringBoot发生错误以后，转发给/error路径，SpringBoot在底层写好了一个`BasicErrorController`:

```java
    @RequestMapping(
        produces = {"text/html"}
    ) //返回html
    public ModelAndView errorHtml(HttpServletRequest request, HttpServletResponse response) {
        HttpStatus status = this.getStatus(request);
        Map<String, Object> model = Collections.unmodifiableMap(this.getErrorAttributes(request, this.getErrorAttributeOptions(request, MediaType.TEXT_HTML)));
        response.setStatus(status.value());
        ModelAndView modelAndView = this.resolveErrorView(request, response, status, model);
        return modelAndView != null ? modelAndView : new ModelAndView("error", model);
    }

    @RequestMapping  //返回ResponseEntity ， JSON
    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
        HttpStatus status = this.getStatus(request);
        if (status == HttpStatus.NO_CONTENT) {
            return new ResponseEntity(status);
        } else {
            Map<String, Object> body = this.getErrorAttributes(request, this.getErrorAttributeOptions(request, MediaType.ALL));
            return new ResponseEntity(body, status);
        }
    }
```

---

错误页面是这么解析到的
```java
//1.解析错误的视图地址
     ModelAndView modelAndView = this.resolveErrorView(request, response, status, model);
//2.如果解析不到错误页面的地址，则转默认的错误页面，默认的错误页面就是 error
        return modelAndView != null ? modelAndView : new ModelAndView("error", model);
```
容器中专门有一个错误视图解析器  
DefaultErrorViewResolver

还有规则：  
1.解析一个错误页，发生了500、404、503、403等这些错误  
  a.如果有模板引擎，默认在`classpath:/templates/error/精确码.html`  
  b.如果没有模板引擎，在静态资源文件夹下找 `精确码.html`  
2.如果匹配不到`精确码.html`这些精确的错误页，就去找`5xx.html`,`4xx.html`,就进行模糊匹配  
  a.如果有模板引擎，默认在`classpath:/templates/error/4/5xx.html`  
  b.如果没有引擎模板，在静态资源文件夹下找 `5xx.html`  
3.如果模板引擎路径下有`error.html`页面，就直接渲染 

最佳实战  
---

****·前后分离****  
  **后台发生的所有错误**，`@ControllerAdvice + @ExceptionHandler`进行统一异常处理。  
**·服务端页面渲染**    
不可预知的一些，HTTP码表示的服务器或客户端错误  
给`classpath:/templates/error/`下面，放常用精确的错误码页面。`500.html`,`400.html`  
给`classpath:/templates/error/`下面，放常用模糊的错误码页面。`5xx.html`,`4xx.html`  
发生业务错误  
核心业务，每一种错误，都应该代码控制，跳转到自己的错误页  
通用业务，`classpath:/templates/error.html`页面，显示通用的错误信息  
---

如果想在页面显示错误信息，可以用model里的信息：  
用法：例如trace直接可以在文本内：[[${trace}]]

```properties
Model可用信息有:
timestamp ->时间戳
status ->状态码
error ->Internal Server Error
trace ->java.lang.ArithmeticException；那些有报错的底层类，那些我看不懂的，也叫错误堆栈
message ->"一些错误提示内容，很有用"
path ->浏览器访问路径
```
