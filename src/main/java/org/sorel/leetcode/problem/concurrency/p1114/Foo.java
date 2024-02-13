package org.sorel.leetcode.problem.concurrency.p1114;

import java.util.concurrent.CountDownLatch;

public class Foo {
    private final CountDownLatch firstDone;
    private final CountDownLatch secondDone;

    public Foo() {
        firstDone = new CountDownLatch(1);
        secondDone = new CountDownLatch(1);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        firstDone.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        firstDone.await();
        printSecond.run();
        secondDone.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        secondDone.await();
        printThird.run();
    }
}
