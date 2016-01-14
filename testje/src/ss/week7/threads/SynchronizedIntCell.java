package ss.week7.threads;

public class SynchronizedIntCell implements IntCell {
	
	private int value = 0;
	private boolean valWaiting = false;
	
	public SynchronizedIntCell() {
	}
	
	public synchronized void setValue(int valueArg) {
		while (valWaiting) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		value = valueArg;
		valWaiting = true;
		notify();
	}

	public synchronized int getValue() {
		while (!valWaiting) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		valWaiting = false;
		notify();
		return value;
	}
}
