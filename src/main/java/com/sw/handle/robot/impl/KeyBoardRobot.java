package com.sw.handle.robot.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sw.handle.robot.IkeyBoardRobot;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;

@Service
public class KeyBoardRobot {

    private Robot robot = null;
	
	public KeyBoardRobot() {
		
		try {
			robot = new Robot();//核心机器人类，用于截图，键盘或鼠标事件的重放执行。
		} catch (AWTException e) {

		}
		
	}

    // @Override
    public void handleMsg(String message) {
        System.out.println("message ===> " + message);
        try {
            // Color color = robot.getPixelColor(0, 0);
            System.out.println("message ===> " + robot == null);
            robot.keyPress(49);
            robot.keyRelease(49);  
        } catch (Exception e) {
            // TODO: handle exception
            // e.printStackTrace();
        }
        
    }

    // public void handleMsg(String message){
    // System.out.println("message ===> " + message);
    // // robot.keyPress(49);
    // // robot.keyRelease(49);
    // }
}
