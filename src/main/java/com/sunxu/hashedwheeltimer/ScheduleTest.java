package com.sunxu.hashedwheeltimer;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author 孙许
 * @version 1.0
 * @date 2021/2/3 18:12
 */
public class ScheduleTest {

    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
        executor.scheduleAtFixedRate(() -> System.out.println("ceshi"), 0, 1, TimeUnit.SECONDS);
    }
}
