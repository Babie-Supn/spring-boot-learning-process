package pres.atbabie.boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//@ResponseBody
@RestController
public class HelloController {
    @GetMapping("/hello")
    public  String Hello(){

        return "Hello SpringBoot3!";

    }
}
