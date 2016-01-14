package ss.week7.account;

public class AccountSync {
	
	private static double amount = 300.00;
	private static double negativeAmount = -300.00;
	private static int frequency = 5;
	
	public static void main(String[] args) {
		Account account = new Account();
		MyThread thread1 = new MyThread(amount, frequency, account);
		MyThread thread2 = new MyThread(negativeAmount, frequency, account);
		thread2.start();
		thread1.start();
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(account.getBalance());
	}
}
