package tech.sench.processor;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.util.Set;

/**
 * 检查指定annotation的语法格式
 * 注意编译注册processor时的包名（根目录中指定）
 * javac -processor tech.sench.processor.NameCheckProcessor tech/sench/processor/BADLY_NAMED_CODE.java
 * Created by zhaoshengqi on 2018/4/12.
 */
@SupportedAnnotationTypes("*")//表示所有class类型
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class NameCheckProcessor extends AbstractProcessor {

    private NameChecker nameChecker;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        nameChecker = new NameChecker(processingEnv);
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        if (!roundEnv.processingOver()) {
            for (Element element : roundEnv.getRootElements())
                nameChecker.checkNames(element);
        }
        return false;
    }
}
