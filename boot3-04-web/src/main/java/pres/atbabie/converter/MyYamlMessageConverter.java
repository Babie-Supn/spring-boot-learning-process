package pres.atbabie.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

public class MyYamlMessageConverter extends AbstractHttpMessageConverter<Object> {

    private ObjectMapper objectMapper=null;

    public MyYamlMessageConverter() {
        super(new MediaType("text", "yaml", Charset.forName("UTF-8")));
        //怎么让springmvc知道我们支持yaml语法
//        MediaType mediaType = new MediaType("application", "yaml", Charset.forName("UTF-8"));
        //告诉springboot这个MessageConverter支持哪种媒体类型


        YAMLFactory factory = new YAMLFactory().disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER);
         this.objectMapper = new ObjectMapper(factory);

    }

    @Override
    protected boolean supports(Class clazz) {
        //只要是对象类型就转
        return true;
    }

    @Override //@RequestBody
    protected Object readInternal(Class clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    @Override  //@ResponseBody 把对象怎么写出去
    protected void writeInternal(Object methodReturnValue, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
       //try-with写法，可以帮我们自动关流
        try(OutputStream os=outputMessage.getBody()){
           objectMapper.writeValue(os,methodReturnValue);
       }
    }
}
