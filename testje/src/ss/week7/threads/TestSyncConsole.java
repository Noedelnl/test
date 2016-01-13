package ss.week7.threads;

public class TestSyncConsole extends Thread{
	
	public TestSyncConsole(String name) {
		super(name);
	}
	
	public synchronized void run() {
		this.sum();
	}
	
	private synchronized void sum() {
		int int1 = SyncConsole.readInt(this.getName() + ": get number 1?");
		int int2 = SyncConsole.readInt(this.getName() + ": get number 2?");
		SyncConsole.println(this.getName() + ": " + int1 + " + " + int2 + " = " + (int1 + int2));
	}
	
	public static void main(String[] args) {
		TestSyncConsole t = new TestSyncConsole("Thread a");
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
		(new TestSyncConsole("Thread b")).start();
	}

}
