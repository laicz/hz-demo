package com.hz.hzdemo.service.impl;

import com.hz.hzdemo.service.NullAnnotationService;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

/**
 * Create by zhoumingbing on 2019-07-21
 */
@Service
public class NullAnnotationServiceImpl implements NullAnnotationService {

    @Override
//    @Nullable
    public String nullable() {
        return null;
    }

    @Override
    @NonNull
    public String nonNull() {
        return null;
    }

    @Override
    public void nullParam(@Nullable Object param) {
        System.out.println(param);
    }

    @Override
    public void nonNullParam(@NonNull Object param) {
        System.out.println(param);
    }
}
