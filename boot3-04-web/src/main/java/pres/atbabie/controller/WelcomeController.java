package pres.atbabie.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pres.atbabie.bean.Person;

import java.util.Arrays;
import java.util.List;

@Controller  //这个适配服务端渲染 前后不分离
public class WelcomeController {

    /**
     * 利用模板引擎跳转到指定页面
     * @return
     */
    @GetMapping("/well")
    public String hello(@RequestParam("name") String name, Model model){

        //和javaweb里的viewBaseServlet 功能对应
        //模板逻辑视图名
        //物理视图 = 前缀 + 后缀
        //真实地址 = classpath:/templates/welcome.html

        //把需要给页面共享的值，添加到model里

        model.addAttribute("msg",name);

        //如果一些资源是动态的
        model.addAttribute("imgUrl","/babie.jpg");
        return "welcome";
    }

    @GetMapping("/list")
    public String forEachTest(Model model){
        List<Person> list= Arrays.asList(
                new Person("皮皮",10),
                new Person("小胖",12),
                new Person("柔柔",9),
                new Person("德芙",2)
        );
        model.addAttribute("lists",list);

        return "forEach";
    }


}
