package com.sw.handle.swhandle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.sw.handle.swhandle.sever.WebSocketServer;
// DataSourceAutoConfiguration
// @ComponentScan("com.sw.handle.swhandle.robot")
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class SwHandleApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext application = SpringApplication.run(SwHandleApplication.class, args);
        WebSocketServer.setApplicationContext(application);
    }

}
