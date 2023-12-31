package pres.atbabie.config;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

public class MyTypeFilter implements TypeFilter {

    /**
     * metadataReader：读取到当前正在扫描的类的信息
     * metadataReaderFactory：可以读取到其他任何类信息的
     * @param metadataReader
     * @param metadataReaderFactory
     * @return
     * @throws IOException
     */

    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {

        //获取当前类注解的信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        //获取当前正在扫描的类的信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        //获取当前类的资源信息
        Resource resource = metadataReader.getResource();

        //获取类名
        String className = classMetadata.getClassName();
        System.out.println("======>"+className);
        if(className.contains("er")){
            return true;
        }
        return false;
    }
}
