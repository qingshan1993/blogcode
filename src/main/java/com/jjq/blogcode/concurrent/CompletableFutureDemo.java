package com.jjq.blogcode.concurrent;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;
import java.util.stream.IntStream;

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

    @Test
    public void test3() throws InterruptedException {
        Thread thread1 = new Thread(() -> IntStream.range(0, 10).forEach(System.out::println));
        Thread thread2 = new Thread(() -> {
            try {
                thread1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            IntStream.range(10, 20).forEach(System.out::println);
        });
        thread1.join();
        thread1.start();
        thread2.start();
    }

    @Test
    public void test4() {
        CompletableFuture
                .runAsync(() -> IntStream.range(0, 10).forEach(System.out::println))
                .thenRunAsync(() -> IntStream.range(10, 20).forEach(System.out::println));
    }

    @Test
    public void test5() {
        //这是错误的写法，执行后，什么也不会发生
        CompletableFuture<Void> completableFuture = new CompletableFuture<>();
        completableFuture
                .thenRunAsync(() -> IntStream.range(0, 10).forEach(System.out::println))
                .thenRunAsync(() -> IntStream.range(10, 20).forEach(System.out::println));
    }

    @Test
    public void test6() {
        CompletableFuture
                .completedFuture(null)
                .thenRun(() -> System.out.println("thenRun 1:" + Thread.currentThread().getName()))
                .thenRun(() -> System.out.println("thenRun 2:" + Thread.currentThread().getName()));
//        thenRun 1:main
//        thenRun 2:main
    }

    @Test
    public void test7() {

        CompletableFuture
                .completedFuture(null)
                .thenRunAsync(() -> System.out.println("thenRunAsync 1:" + Thread.currentThread().getName()))
                .thenRunAsync(() -> System.out.println("thenRunAsync 2:" + Thread.currentThread().getName()));
        //thenRunAsync 1:ForkJoinPool.commonPool-worker-9
        //thenRunAsync 2:ForkJoinPool.commonPool-worker-9
    }

    @Test
    public void test8() throws InterruptedException {
        final String name = "qingshan193";
        CompletableFuture
                .supplyAsync(() -> "Hello, ")
                .thenApply(x -> { return x + name + ", ";})
                .thenApply(x -> {
                    if (x.contains("qingshan1993")) {
                        return x + "welcome to study";
                    } else {
                        throw new IllegalArgumentException(" must contains 'qingshan1993'");
                    }})
                //.exceptionally(ex-> "ERROR!")
                .thenAccept(x -> System.out.println(x +" CompletableFuture"));
        //name=qingshan1993, result = Hello, qingshan1993, welcome to study CompletableFuture
        //name=qingshan, result = ERROR! CompletableFuture
    }

    @Test
    public void test9() throws InterruptedException {
        //thenCombine

    }

    @Test
    public void test10() throws InterruptedException {
        //

    }






}
