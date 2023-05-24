package com.sw.handle.swhandle.sever;

import java.awt.Robot;
import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import com.sw.handle.swhandle.robot.IkeyBoardRobot;
import com.sw.handle.swhandle.robot.impl.KeyBoardRobot;

@ServerEndpoint("/websocket") // 访问路径: ws://localhost:8080/websocket
@Component
public class WebSocketServer {


    private static ConfigurableApplicationContext applicationContext;

    public static void setApplicationContext(ConfigurableApplicationContext context){
        applicationContext = context;
    }


    @Autowired(required = false)
    private KeyBoardRobot robot;

    // 第一次连接调用
    @OnOpen
    public void open(Session session) throws IOException {
        System.out.println("connect..");
        session.getBasicRemote().sendText("server: 登陆成功!");
    }

    // 关闭连接调用
    @OnClose
    public void close() {
        System.out.println("disconnect..");
    }

    // 接收消息
    @OnMessage
    public void message(String message, Session session) {
        System.out.println("message ===> " + message);
        Object a = applicationContext.getBean(KeyBoardRobot.class);
        if(a instanceof KeyBoardRobot){
            robot = (KeyBoardRobot)a;
            robot.handleMsg(message);
            try {
                session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                // ated catch block
                e.printStackTrace();
            }
        }

       
        // robot.keyPress(49);
        // robot.keyRelease(49);
    }
}
//2023-05-19 17:41:22
// client:1684489282768
// server:1684489225896
//2023-05-19 17:40:25
