package com.hz.hzdemo.concurrency.basics;

import java.util.Objects;

/**
 * Create by zhoumingbing on 2019-09-11
 */
public class PreRequestProcessor implements RequestProcessor {

    private RequestProcessor nextProcessor;

    public PreRequestProcessor(RequestProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    @Override
    public void processor() {
        doProcessor();
        if (Objects.nonNull(nextProcessor)) {
            nextProcessor.processor();
        }
    }

    private void doProcessor() {
        //  do something
    }
}
