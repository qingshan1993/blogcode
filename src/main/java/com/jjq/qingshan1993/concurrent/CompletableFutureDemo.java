package com.jjq.qingshan1993.concurrent;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

/**
 * @author qingshan1993
 * @version 1.0
 * @date 2022/8/2
 * @desc
 */
public class CompletableFutureDemo {


    @Test
    public void test1() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        //这里使用了lamada表达式，等待500ms，然后返回一个qingshang1993字符串
        Callable<String> task = () -> {
            Thread.sleep(500);
            return "qingshang1993";
        };
        Future<String> future = executor.submit(task);
        String result = future.get();
        System.out.println("result: " + result);
    }

    @Test
    public void test2() throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        ExecutorService executor = Executors.newFixedThreadPool(5);
        executor.submit(()->{
            Thread.sleep(500);
            completableFuture.complete("qingshang1993");
            return null;
        });
        String result = completableFuture.get();
        System.out.println("result: " + result);
    }







}
