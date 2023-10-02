package pres.atbabie.boot3.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pres.atbabie.boot3.ssm.bean.UserDetail;
import pres.atbabie.boot3.ssm.mapper.UserMapper;

@RestController
public class UserController {

    @Autowired
    UserMapper userMapper;

    /**
     * 因为是 @RestController 所以，返回页面的内容就是return的内容，一般一json的格式返回
     *
     * @param id
     * @return
     */

    @GetMapping("/user/{id}")
    public UserDetail getUser(@PathVariable("id") Long id){
        UserDetail user = userMapper.getUserById(id);


        return user;
    }
}
