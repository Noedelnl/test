package ss.week1;

public class DollarsAndCentsCounter {
		int amount;
	
		public DollarsAndCentsCounter(){
			amount = 0;
		}
		
		public int dollars(){
			return amount / 100;
		}
		
		public int cents(){
			return amount % 100;
		}
		
		public void add(int addDollars, int addCents){
			amount = amount + addDollars * 100 + addCents;
		}
		
		public void reset(){
			amount = 0;
		}
}
