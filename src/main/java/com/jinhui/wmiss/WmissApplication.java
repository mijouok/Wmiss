package com.jinhui.wmiss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.jinhui.entity"})
//@EnableJpaRepositories(basePackages = {"com.jinhui.wmiss.dao"})
public class WmissApplication {

    public static void main(String[] args) {
        SpringApplication.run(WmissApplication.class, args);
    }

}
