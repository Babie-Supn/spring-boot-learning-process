package pres.atbabie.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

//自定义逻辑，返回需要导入的组件
public class MyImportSelector implements ImportSelector {

    //返回值就是要导入到容器中的组件的全类名
    //AnnotationMetadata：当前标注@Import注解的类的所有注解信息
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        //
//        Class<? extends AnnotationMetadata> aClass = importingClassMetadata.getClass();

        //方法不要返回null值，不然会空指针
        return new String[]{"pres.atbabie.bean.Blue","pres.atbabie.bean.Yellow"};
    }


}
