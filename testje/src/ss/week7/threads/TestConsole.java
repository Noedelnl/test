package ss.week7.threads;

public class TestConsole extends Thread {
	
	public TestConsole(String name) {
		super(name);
	}
	
	public void run() {
		this.sum();
	}
	
	private void sum() {
		int int1 = Console.readInt(this.getName() + ": get number 1?");
		int int2 = Console.readInt(this.getName() + ": get number 2?");
		Console.println(this.getName() + ": " + int1 + " + " + int2 + " = " + (int1 + int2));
	}
	
	public static void main(String[] args) {
		(new TestConsole("Thread a")).start();
		(new TestConsole("Thread b")).start();
	}

}
