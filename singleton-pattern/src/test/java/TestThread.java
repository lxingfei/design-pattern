import com.leh.singleton.multiway.SingletonLazy1;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;


/**
 * CountDownLatch ，字面意思是减小计数（CountDown）的门闩（Latch）。
 * 它要做的事情是，等待指定数量的计数被减少，意味着门闩被打开，然后进行执行。
 */
public class TestThread {

	public static void main(String[] args) {
		//启动100线程同时去抢CPU
		int count = 20;

		//发令枪，测试并发经常用到
		CountDownLatch latch = new CountDownLatch(count);
		//Set默认去去重的，set是本身线程不安全的
		final Set<SingletonLazy1> syncSet = Collections.synchronizedSet(new HashSet<SingletonLazy1>());

		for (int i = 0; i < count; i++) {
			new Thread(){
				@Override
				public void run() {
					SingletonLazy1 instance = SingletonLazy1.getInstance();
					syncSet.add(instance);
					latch.countDown();
					System.out.println(Thread.currentThread().getName() + ">>>>>>>>>>>>" + instance + "计数器还剩" + latch.getCount());
				}
			}.start();
		}

		try {
			//在这里阻塞  只有计数器为0的时候这行代码才会释放
			latch.await();
			System.out.println(Thread.currentThread().getName() + ">>>>>>" + syncSet.size());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
