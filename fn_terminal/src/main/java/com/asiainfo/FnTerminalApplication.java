package com.asiainfo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableTransactionManagement //开启事务管理, 在对应的service public方法 加 @Transactional
@MapperScan("com.asiainfo.mapper")
@SpringBootApplication
public class FnTerminalApplication {

    public static void main(String[] args) {
        SpringApplication.run(FnTerminalApplication.class, args);
    }

}
