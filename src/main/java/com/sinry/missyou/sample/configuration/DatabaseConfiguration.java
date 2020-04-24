package com.sinry.missyou.sample.configuration;

import com.sinry.missyou.sample.IConnect;
import com.sinry.missyou.sample.databases.MySQL;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfiguration {

    @Value("${mysql.ip}")
    private String ip;
    @Value("${mysql.port}")
    private Integer port;

    @Bean
    public IConnect Mysql () {
        return new MySQL(this.ip, this.port);
    }
}
