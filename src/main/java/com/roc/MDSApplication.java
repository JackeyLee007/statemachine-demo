package com.roc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.roc.presto")
public class MDSApplication {
    public static void main(String[] args) {
        SpringApplication.run(MDSApplication.class, args);
    }
}
