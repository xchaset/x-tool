package com.xchaset.xtool;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xchaset.xtool.**.mapper")
public class XToolApplication {

    public static void main(String[] args) {
        SpringApplication.run(XToolApplication.class, args);
    }

}
