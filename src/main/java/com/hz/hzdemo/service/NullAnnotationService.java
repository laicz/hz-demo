package com.hz.hzdemo.service;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * Create by zhoumingbing on 2019-07-21
 */
public interface NullAnnotationService {

    @Nullable
    String nullable();

    @NonNull
    String nonNull();

    void nullParam(Object param);

    void nonNullParam(@NonNull Object param);
}
