package org.sorel.leetcode.problem.concurrency.p1195;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

public class FizzBuzz {
    private final int n;
    private final Semaphore semaphore = new Semaphore(1);
    private final AtomicInteger curr = new AtomicInteger(1);

    public FizzBuzz(int n) {
        this.n = n;
    }

    public void fizz(Runnable printFizz) throws InterruptedException {
        while (true) {
            semaphore.acquire(1);
            try {
                if (curr.get() > n) {
                    return;
                }

                if (curr.get() % 3 == 0 && curr.get() % 5 != 0) {
                    curr.incrementAndGet();
                    printFizz.run();
                }
            } finally {
                semaphore.release(1);
            }
        }
    }

    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (true) {
            semaphore.acquire(1);
            try {
                if (curr.get() > n) {
                    return;
                }

                if (curr.get() % 3 != 0 && curr.get() % 5 == 0) {
                    curr.incrementAndGet();
                    printBuzz.run();
                }
            } finally {
                semaphore.release(1);
            }
        }
    }

    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (true) {
            semaphore.acquire(1);
            try {
                if (curr.get() > n) {
                    return;
                }

                if (curr.get() % 3 == 0 && curr.get() % 5 == 0) {
                    curr.incrementAndGet();
                    printFizzBuzz.run();
                }
            } finally {
                semaphore.release(1);
            }
        }
    }

    public void number(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            semaphore.acquire(1);
            try {
                if (curr.get() > n) {
                    return;
                }

                if (curr.get() % 3 != 0 && curr.get() % 5 != 0) {
                    printNumber.accept(curr.get());
                    curr.incrementAndGet();
                }
            } finally {
                semaphore.release(1);
            }
        }
    }
}
