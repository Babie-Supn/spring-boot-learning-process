package pres.atbabie.biz;

import jakarta.servlet.ServletException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;
import pres.atbabie.bean.Person;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * 专门处理User有关的业务
 */
@Slf4j
@Service
public class UserBizHandler {

    public ServerResponse getUser(ServerRequest request)throws Exception{
        String id=request.pathVariable("id");
        log.info("查询用户"+id+"信息完成");
        //业务处理
        Person person = new Person("花花", 1);
        //构造响应
//            return ServerResponse.ok().build();
        return ServerResponse.ok().body(person);
    }
    public ServerResponse getUsers(ServerRequest request)throws Exception{
        //业务处理
        List<Person> list = Arrays.asList(new Person("多多", 20)
                , new Person("花花", 1));
        //构造响应
//            return ServerResponse.ok().build();
        return ServerResponse.ok().body(list);//凡是body中的对象，就是以前@ResponseBody原理，利用HttpMessageConverter 写出为json，当然也可以通过内容协商，写成别的
    }

    public ServerResponse saveUser(ServerRequest request) throws ServletException, IOException {
        //提取请求体
        Person body=request.body(Person.class);
        log.info("保存用户信息{}",body);
        return ServerResponse.ok().build();
    }

}
