package ss.week7.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FinegrainedIntCell implements IntCell{
	
	private Lock lock = new ReentrantLock();
	private Condition valWritten = lock.newCondition();
	private Condition valRead = lock.newCondition();
	private int value = 0;
	private boolean valWaiting = false;
	
	public void setValue(int valueArg) {
		lock.lock();
		try {
			while (valWaiting) {
					valRead.await();
			}
			this.value = valueArg;
			valWaiting = true;
			valWritten.signal();
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		} 
		finally {
			lock.unlock();
		}
	}

	public int getValue() {
		lock.lock();
		try {
		while (!valWaiting) {
				valWritten.await();
			}
			valWaiting = false;
			valRead.signal();
			return value;
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
			return -1;
		}
		finally {
			lock.unlock();
		}
	}
}
