package com.sw.handle.swhandle;

import java.util.regex.Pattern;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import com.sw.handle.swhandle.sever.WebSocketServer;

import java.util.regex.Matcher;

// DataSourceAutoConfiguration
// @ComponentScan("com.sw.handle.swhandle.robot")
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class SwHandleApplication {

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new
        SpringApplicationBuilder(SwHandleApplication.class);
        ConfigurableApplicationContext application =
        builder.headless(false).run(args);
        WebSocketServer.setApplicationContext(application);

    }

}
