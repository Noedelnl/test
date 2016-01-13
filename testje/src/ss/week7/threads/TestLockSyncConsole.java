package ss.week7.threads;

import java.util.concurrent.locks.ReentrantLock;

public class TestLockSyncConsole extends Thread {
	private final ReentrantLock lock;
	
	public TestLockSyncConsole(String name) {
		super(name);
		lock = new ReentrantLock();
	}
	
	public void run() {
		lock.lock();
		this.sum();
		lock.unlock();
	}
	
	private void sum() {
		int int1 = SyncConsole.readInt(this.getName() + ": get number 1?");
		int int2 = SyncConsole.readInt(this.getName() + ": get number 2?");
		SyncConsole.println(this.getName() + ": " + int1 + " + " + int2 + " = " + (int1 + int2));
	}
	
	public static void main(String[] args) {
		(new TestLockSyncConsole("Thread a")).start();
		(new TestLockSyncConsole("Thread b")).start();
	}

}

