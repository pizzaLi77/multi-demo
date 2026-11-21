package com.spi.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j // 自动生成 log 字段，用于记录业务方法及其执行线程。
@Service
public class TestService {


    @Async
    public void testMethod(){
        log.info("testMethod方法对应线程：{}正在运行。。。", Thread.currentThread().getName());
    }

    public void testMethod1(){
        log.info("testMethod1方法对应线程：{}正在运行。。。", Thread.currentThread().getName());
    }
}
