使用并发原语实现按序打印，推荐

```java
public class Foo {
    private volatile int flag = 1;
    private final Object object = new Object();

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (object) {
            while (flag != 1) {
                object.wait();
            }

            printFirst.run();
            flag = 2;
            object.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (object) {
            while (flag != 2) {
                object.wait();
            }

            printSecond.run();
            flag = 3;
            object.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (object) {
            while (flag != 3) {
                object.wait();
            }
        }
        printThird.run();
    }
}
```

使用原子类实现按序打印

```java
public class Foo {
    private final AtomicInteger atomic = new AtomicInteger(1);

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        while (atomic.get() != 1) {

        }
        printFirst.run();
        atomic.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (atomic.get() != 2) {

        }
        printSecond.run();
        atomic.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (atomic.get() != 3) {
            
        }
        printThird.run();
    }
}
```

使用并发工具类实现按序打印

```java
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
```