package org.selina.ptj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@MapperScan(basePackages = "org.selina.ptj.mapper")
public class PtjApplication {

    public static void main(String[] args) {
        SpringApplication.run(PtjApplication.class, args);
    }

}
