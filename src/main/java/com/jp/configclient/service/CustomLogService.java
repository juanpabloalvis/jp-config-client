package com.jp.configclient.service;

//import io.micrometer.tracing.Span;
//import io.micrometer.tracing.Tracer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomLogService {

   @Autowired
//   private Tracer tracer;
    private static final Logger log = LoggerFactory.getLogger(CustomLogService.class);

    public void printLog() {
//        Span newSpan = tracer.nextSpan().name("customSpanInService");
//        try (Tracer.SpanInScope ws = this.tracer.withSpan(newSpan.start())) {

            log.info("LogService");
//        } finally {
//            newSpan.end();
//        }
    }
}
