package com.cosyfish.autosend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication
@MapperScan("com.cosyfish.autosend.mapper")
public class AutosendApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutosendApplication.class, args);
    }

}
