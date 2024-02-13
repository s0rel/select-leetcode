package org.sorel.leetcode.problem.concurrency.p1116;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class ZeroEvenOdd {
    private final int n;
    private final AtomicInteger flag = new AtomicInteger(1);
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            lock.lock();
            try {
                printNumber.accept(0);
                flag.incrementAndGet();
                condition.signalAll();

                while (flag.get() % 2 == 0) {
                    condition.await();
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            lock.lock();
            try {
                while (flag.get() % 4 != 0) {
                    condition.await();
                }

                printNumber.accept(i);
                flag.incrementAndGet();
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            lock.lock();
            try {
                while (flag.get() % 4 != 2) {
                    condition.await();
                }

                printNumber.accept(i);
                flag.incrementAndGet();
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }
}
