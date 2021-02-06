package com.sunxu.hashedwheeltimer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author 孙许
 * @version 1.0
 * @date 2021/2/3 18:05
 */
public class TimerTest {

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("task1");
            }
        }, 0, 1000);     }
}
