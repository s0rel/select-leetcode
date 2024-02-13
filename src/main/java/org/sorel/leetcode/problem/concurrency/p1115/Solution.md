其他解法

* 使用并发工具类实现交替打印

```java
public class FooBar {
    private final int n;
    private final Semaphore foo = new Semaphore(1);
    private final Semaphore bar = new Semaphore(0);

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

* 自旋 + 让出 CPU 实现交替打印

```java
public class FooBar {
    private final int n;
    private volatile boolean permit = true;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; ) {
            if (permit) {
                printFoo.run();
                i++;
                permit = false;
            } else {
                Thread.yield();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; ) {
            if (!permit) {
                printBar.run();
                i++;
                permit = true;
            } else {
                Thread.yield();
            }
        }
    }
}
```