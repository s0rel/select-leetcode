package org.sorel.leetcode.problem.concurrency.p1115;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FooBar {
    private final int n;
    private final Lock lock = new ReentrantLock(true);
    private final Condition condition = lock.newCondition();
    private volatile boolean flag = true;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                while (!flag) {
                    condition.await();
                }

                printFoo.run();
                flag = false;
                condition.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                while (flag) {
                    condition.await();
                }

                printBar.run();
                flag = true;
                condition.signal();
            } finally {
                lock.unlock();
            }
        }
    }
}
