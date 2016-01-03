package ss.week2;

public class Rectangle {
	//@ private invariant requires length >= 0;
	private int length;
	//@ private invariant requires width >= 0;
	private int width;
	/**
	 * 
	 * @param newLength
	 * @param newWidth
	 */
	/*@ requires newLength >= 0 && newWidth >=0; 
	ensures length() == newLength && width() == newWidth; @*/
	public Rectangle(/*@non_null@*/int newLength, /*@non_null@*/int newWidth){
		assert newLength >= 0 && newWidth >=0;
		length = newLength;
		width = newWidth;
	}
	
	//@ pure;
	public int length() {
		assert length >= 0;
		return length;
	}
	
	//@ pure;
	public int width() {
		assert width >= 0;
		return width;
	}
	
	/*@ ensures \result == length*width; @*/
	public int area() {
		assert length >= 0 && width >= 0;
		return length*width;
	}
	
	/*@	ensures \result == 2*length + 2*width; @*/
	public int perimeter() {
		assert length >= 0 && width >= 0;
		return 2*length + 2*width;
	}
}
