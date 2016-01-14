package ss.week7.account;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
	protected double balance = 0.0;
	private Lock lock = new ReentrantLock();
	private Condition waitingForBalance = lock.newCondition();

	public void transaction(double amount) {
		lock.lock();
		while ((balance + amount) < -1000 ) {
			try {
				waitingForBalance.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		balance = balance + amount;
		waitingForBalance.signal();
		lock.unlock();
	}
	public double getBalance() {
		return balance;
	}
}
