package com.sw.handle.swhandle.robot.impl;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeInputEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;

@Service
public class KeyBoardRobot {

    private Robot robot = null;
    private Map<String, NativeKeyEvent> keyEventMap = new HashMap<String, NativeKeyEvent>();

    public KeyBoardRobot() {

        try {
            robot = new Robot();
        } catch (AWTException e) {
        }
    }

    private NativeKeyEvent getKeyEvent(int rawCode, boolean down) {
        char keyChar = (char) rawCode;
        int keyCode = getKeyCode(rawCode);
        NativeKeyEvent pressKey = new NativeKeyEvent(
                down ? NativeKeyEvent.NATIVE_KEY_PRESSED : NativeKeyEvent.NATIVE_KEY_RELEASED,
                NativeKeyEvent.SHIFT_MASK,
                rawCode,
                keyCode,
                keyChar);
        return pressKey;
    }

    private int getKeyCode(int rawCode) {
        switch (rawCode) {
            case KeyEvent.VK_A:
                return NativeKeyEvent.VC_A;
            case KeyEvent.VK_D:
                return NativeKeyEvent.VC_D;
            case KeyEvent.VK_F:
                return NativeKeyEvent.VC_F;


                case KeyEvent.VK_J:
                return NativeKeyEvent.VC_J;

            case KeyEvent.VK_K:
            return NativeKeyEvent.VC_K;
            case KeyEvent.VK_I:
            return NativeKeyEvent.VC_I;

            case KeyEvent.VK_U:
                return NativeKeyEvent.VC_U;
            case KeyEvent.VK_S:
                return NativeKeyEvent.VC_S;
            case KeyEvent.VK_W:
                return NativeKeyEvent.VC_W;
        }
        return 0;
    }

    private void keyPress(int keyCode) {
        GlobalScreen.postNativeEvent(getKeyEvent(keyCode, true));
    }

    private void keyRelease(int keyCode) {
        GlobalScreen.postNativeEvent(getKeyEvent(keyCode, false));
    }

    // @Override
    public void handleMsg(String message) {
        printLog("message ===> " + message);
        if (message.startsWith("u")) {
            printLog("message ===> up");
            String pattern = "(\\d+)";
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(message);
            int matcher_start = 0;
            while (m.find(matcher_start)) {
                int keyCode = Integer.parseInt(m.group(1));
                keyRelease(keyCode);
                matcher_start = m.end();
            }
        } else if (message.startsWith("d")) {
            printLog("message ===> down");
            String pattern = "(\\d+)";
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(message);
            int matcher_start = 0;
            while (m.find(matcher_start)) {
                int keyCode = Integer.parseInt(m.group(1));
                printLog("keyCode ===> " + keyCode);
                keyPress(keyCode);
                matcher_start = m.end();
            }
        }
    }

    private void printLog(String log) {
        String timeStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS", Locale.CHINA)
                .format(Calendar.getInstance().getTime());
        System.out.println(timeStr + " : " + log);
    }
}
