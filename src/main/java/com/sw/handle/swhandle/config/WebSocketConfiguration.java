package com.sw.handle.swhandle.config;

import java.awt.AWTException;
import java.awt.Robot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import com.sw.handle.robot.impl.KeyBoardRobot;

@Configuration
public class WebSocketConfiguration {

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

    @Bean
    public KeyBoardRobot keyBoardRobot() {
        return new KeyBoardRobot();
    }

}
