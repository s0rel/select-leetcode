可重入锁实现交替打印，推荐

```java
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
```

使用并发工具类实现交替打印

```java
public class FooBar {
    private final int n;
    private final Semaphore foo = new Semaphore(1);
    private final Semaphore bar = new Semaphore(1);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            foo.acquire();
            printFoo.run();
            bar.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            bar.acquire();
            printBar.run();
            foo.release();
        }
    }
}
```

自旋 + 让出 CPU 实现交替打印

```java
public class FooBar {
    private final int n;
    private volatile boolean premit = true;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; ) {
            if (premit) {
                printFoo.run();
                i++;
                premit = false;
            } else {
                Thread.yield();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; ) {
            if (!premit) {
                printBar.run();
                i++;
                premit = true;
            } else {
                Thread.yield();
            }
        }
    }
}
```