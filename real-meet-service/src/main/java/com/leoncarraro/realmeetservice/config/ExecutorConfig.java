package com.leoncarraro.realmeetservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
public class ExecutorConfig {

    @Bean
    public Executor executor(
            @Value("${ realmeet.executor.pool.core-pool-size:10 }") int corePoolSize,
            @Value("${ realmeet.executor.pool.max-pool-size:20 }") int maxPoolSize,
            @Value("${ realmeet.executor.pool.keep-alive-seconds:60 }") int keepAliveSeconds,
            @Value("${ realmeet.executor.pool.queue-capacity:50 }") int queueCapacity
    ) {
        return new ThreadPoolExecutor(
                corePoolSize,
                maxPoolSize,
                keepAliveSeconds,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(queueCapacity, true));
    }
}
