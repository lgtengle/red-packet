package com.lg.redpacket.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author panghao
 * @date 2018/11/26 下午 8:08
 */
@Configuration
public class ThreadPoolConfig {

    @Value("${thread.pool.corePoolSize}")
    private Integer corePoolSize;
    @Value("${thread.pool.maximumPoolSize}")
    private Integer maximumPoolSize;
    @Value("${thread.pool.keepAliveTime}")
    private Integer keepAliveTime;

    @Bean(name = "threadPoolExecutor")
    public ThreadPoolExecutor threadPoolExecutor() {
        return new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS, new ArrayBlockingQueue<>(100));
    }
}
