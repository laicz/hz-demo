package com.hz.hzdemo.nullannotation;

import com.hz.hzdemo.HzDemoApplication;
import com.hz.hzdemo.service.NullAnnotationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 使用@NonNull和@Nullable注释，可以让方法的参数和返回值更加的严谨，增加代码的可读性
 * 在代码层面也会有相应的提示，这样能够让空指针异常发生的更少
 * Create by zhoumingbing on 2019-07-21
 */
@ContextConfiguration
@RunWith(value = SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = HzDemoApplication.class)
public class NullAnnotationServiceTest {

    @Autowired
    private NullAnnotationService nullAnnotationService;

    @Test
    public void nullableTest() {
        String nullable = nullAnnotationService.nullable();
        String substring = nullable.substring(1);
        System.out.println(substring);
    }

    @Test
    public void nonNull() {
        String nonNull = nullAnnotationService.nonNull();
        String substring = nonNull.substring(1);
        System.out.println(substring);
    }


    @Test
    public void nullableParam() {
        nullAnnotationService.nullParam(null);
    }

    /**
     * 使用
     */
    @Test
    public void nonNullParam() {
        nullAnnotationService.nonNullParam(null);
    }
}
