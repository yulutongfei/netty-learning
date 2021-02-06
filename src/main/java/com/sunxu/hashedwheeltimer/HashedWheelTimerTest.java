package com.sunxu.hashedwheeltimer;

import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.Timer;
import io.netty.util.TimerTask;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author 孙许
 * @version 1.0
 * @date 2021/2/2 21:59
 */
public class HashedWheelTimerTest {

    public static void main(String[] args) {
        Timer timer = new HashedWheelTimer();
        Timeout timeout1 = timer.newTimeout(timeout -> System.out.println("timeout1: " + new Date()), 10, TimeUnit.SECONDS);
        if (!timeout1.isExpired()) {
            timeout1.cancel();
        }
        timer.newTimeout(timeout -> {
            System.out.println("timeout2: " + new Date());
            Thread.sleep(5000);
        }, 1, TimeUnit.SECONDS);
        timer.newTimeout(timeout -> {
            System.out.println("timeout3: " + new Date());
        }, 3, TimeUnit.SECONDS);
    }
}
