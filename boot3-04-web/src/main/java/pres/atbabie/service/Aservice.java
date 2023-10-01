package pres.atbabie.service;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Service
public class Aservice {
    public void b(){
        System.out.println("b方法被调用了");
        //获取当前请求路径
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        //任意位置随时通过 RequestContextHolder 获取到当前请求和响应的信息
        HttpServletRequest request = attributes.getRequest();
        String uri = request.getRequestURI();
        System.out.println("请求路径是:"+uri);
    }
}
