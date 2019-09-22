package com.hz.hzdemo.annotation;

import com.hz.hzdemo.validate.InEnumValidator;

import javax.validation.Constraint;
import java.lang.annotation.*;

/**
 * Create by zhoumingbing on 2019-08-02
 */
@Target(value = {
        ElementType.METHOD,
        ElementType.FIELD,
        ElementType.ANNOTATION_TYPE,
        ElementType.CONSTRUCTOR,
        ElementType.PARAMETER,
        ElementType.TYPE_USE
})
@Retention(RetentionPolicy.RUNTIME)
@Documented
//@Constraint(validatedBy = InEnumValidator.class)
public @interface InEnum {
}
