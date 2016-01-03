package ss.week4;

/**
 * Class Exercises.
 * @author Saul
 *
 */
public class Exercises {
	
	/**
	 * Method countNegativeNumbers.
	 * @param input array
	 * @return the amount of negative numbers in the array
	 */
    public static int countNegativeNumbers(int[] arr) {
    	int res = 0;
		for (int i = 0; i < arr.length;i++){
			if(arr[i] < 0) {
				res++;
			}
		}
		return res;
    }
    
    /**
     * Method reverseArray.
     * @param The reversed input 
     */
    public static void reverseArray(int[] ints) {
    	for (int i = 0; i < ints.length/2;i++) {
			int temp = ints[i];
			ints[i] = ints[ints.length-1-i];
			ints[ints.length-1-i] = temp;
		}
    }

    class SimpleList {
        public class Element {}

        public class Node {
            public Node next;
            public Element element;
        }

        private Node first;

        private Node find(Element element) {
            Node p = first;
            if (p == null) {
                return null;
            }
            while (p.next != null && !p.next.element.equals(element)) {
                p = p.next;
            }
            if (p.next == null) {
                return null;
            } else {
                return p;
            }
        }

        public void remove(Element element) {
            Node p = find(element);
            if (p != null) {
                p.next = p.next.next;
            }
        }
    }
}
