package pres.atbabie.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
//    @Autowired
//    StringRedisTemplate redisTemplate;


    @GetMapping("/haha")
    public String hello(){
        return "hello demo02";
    }

//    @GetMapping("/redis")
//    public String incr(){
//        Long hello = redisTemplate.opsForValue().increment("hello");
//        return "增加后的值"+hello;
//    }



}
