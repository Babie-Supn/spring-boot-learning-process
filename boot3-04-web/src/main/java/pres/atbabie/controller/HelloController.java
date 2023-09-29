package pres.atbabie.controller;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pres.atbabie.bean.Person;

import java.util.Locale;

@RestController//这个适配前后端分离
public class HelloController {
    /**
     * 默认使用新版的PathPatternParse 进行路径匹配
     * 但如果路径中间有** 那么会报错，不支持这种格式
     *如果想要换路径匹配策略，可以配置更换匹配策略
     *
     * Ant 风格的路径模式语法具有以下规则：
     * ● *：表示任意数量的字符。
     * ● ?：表示任意一个字符。
     * ● **：表示任意数量的目录。
     * ● {}：表示一个命名的模式占位符。
     * ● []：表示字符集合，例如[a-z]表示小写字母。
     *
     * ● PathPatternParser 兼容 AntPathMatcher语法，并支持更多类型的路径模式
     * ● PathPatternParser  "**" 多段匹配的支持仅允许在模式末尾使用
     */
    @GetMapping("/a*/*/b")
    public String Hello(HttpServletRequest req,@PathVariable("p1") String path){
        String url=path;
        return path;
    }

    /**
     * 1.默认支持把对象写为json，因为默认web场景导入了jackson处理json的包；jackson-core
     *
     * @return
     */
    @GetMapping("/person")
    public Person person(){

        return new Person("蛋蛋", 2);
    }

//    public static void main(String[] args) throws JsonProcessingException {
//        Person person = new Person("蛋蛋", 2);
//
//        //如果不想要开头的三条标记线，可以在Yaml工厂里禁用
//        YAMLFactory factory = new YAMLFactory().disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER);
//
//        ObjectMapper objectMapper = new ObjectMapper(factory);
//        String s = objectMapper.writeValueAsString(person);
//        System.out.println(s);
//
//
//    }
    @Autowired
    MessageSource messageSource;

    @GetMapping("/haha")
    public String hah(HttpServletRequest request){
        Locale locale = request.getLocale();
        //利用代码方式获取国际化配置文件中指定的配置项的值
        String login = messageSource.getMessage("login", null, locale);
        return login;
    }
}
