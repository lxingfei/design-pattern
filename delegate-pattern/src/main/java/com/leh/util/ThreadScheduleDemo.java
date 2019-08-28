package com.leh.util;

/**
 * @Auther: leh
 * @Date: 2019/8/26 16:13
 * @Description:
 * 对于一个已经竞争到同步锁的线程，在还没有走出同步块的时候，即使时间片结束也不会释放锁。
    另外，对于通过调用sleep或wait，notify方法主动挂起线程的情况：
    通过sleep方式也是不会释放同步锁的，而 wait,notify是会释放锁的，
 */
public class ThreadScheduleDemo {
    private byte[] tlock = new byte[0];

    public void testSyn() {
        Thread t1 = new Thread(new TestRunable(tlock), "AAA");
        Thread t2 = new Thread(new TestRunable(tlock), "BBB");
        t2.start();
        t1.start();
    }

    public static void main(String[] args) {
        new ThreadScheduleDemo().testSyn();
    }


    class TestRunable implements Runnable{

        private byte[] lock;

        public TestRunable(byte[] lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            synchronized(lock){

                for(int i=0;i<10;i++) {
                    System.out.println(Thread.currentThread().getName());
                    try {
                        //Thread.sleep(1000);
                        lock.notify();
                        if(i<9) {
                            lock.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }

        }

    }
}
