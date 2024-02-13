package org.sorel.leetcode.problem.concurrency.p1117;

import java.util.concurrent.Semaphore;

public class H2O {
    private final Semaphore H = new Semaphore(2);
    private final Semaphore O = new Semaphore(0);

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        H.acquire(1);
        releaseHydrogen.run();
        O.release(1);
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        O.acquire(2);
        releaseOxygen.run();
        H.release(2);
    }
}
