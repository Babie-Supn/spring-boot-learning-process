package pres.atbabie.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloController {
//   Logger logger= LoggerFactory.getLogger(getClass());
    @GetMapping("/hello")
    private String hello(){

        log.trace("trace 日志");
        log.debug("debug 日志");
        log.error("error 日志");
        log.warn("warn   日志");
        log.info("哈哈哈，方法进来了");
//        logger.info("哈哈哈 方法进来了");
        return "Hello,SpringBoot Logging";
    }
}
