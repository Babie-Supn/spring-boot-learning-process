package pres.atbabie.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 */
@ControllerAdvice  //这个注解告诉spring，这个类是集中处理所有 @Controller 发生的错误

public class GlobalExceptionHandler {

    /**
     * 1、@ExceptionHandler 标识一个方法处理错误，默认只能处理这个类发生的指定错误
     * 2、@ControllerAdvice 统一处理所有错误
     * @param e
     * @return
     */
    @ResponseBody //对象写出为json
    @ExceptionHandler(Exception.class)
    public String handlerException(Exception e){
        return "这是我们的统一处理错误操作，错误原因是："+e.getMessage();
    }
}
