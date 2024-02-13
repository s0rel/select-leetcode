package org.sorel.leetcode.problem.concurrency.p1226;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosophers {
    private final Lock[] lockList = {new ReentrantLock(),
            new ReentrantLock(),
            new ReentrantLock(),
            new ReentrantLock(),
            new ReentrantLock()};

    private Semaphore eatLimit = new Semaphore(4);

    public DiningPhilosophers() {

    }

    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {

        int leftFork = (philosopher + 1) % 5;
        int rightFork = philosopher;

        eatLimit.acquire();

        lockList[leftFork].lock();
        lockList[rightFork].lock();

        pickLeftFork.run();
        pickRightFork.run();

        eat.run();

        putLeftFork.run();
        putRightFork.run();

        lockList[leftFork].unlock();
        lockList[rightFork].unlock();

        eatLimit.release();
    }
}

