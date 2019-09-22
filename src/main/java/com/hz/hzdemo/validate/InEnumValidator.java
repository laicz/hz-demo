package com.hz.hzdemo.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Create by zhoumingbing on 2019-08-02
 */
public class InEnumValidator implements ConstraintValidator {
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        return false;
    }
}
