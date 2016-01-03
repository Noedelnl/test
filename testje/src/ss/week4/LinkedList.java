package ss.week4;

/**
 * Class LinkedList.
 * @author Noel
 *
 */
public class LinkedList<Element> {
    private /*@ spec_public @*/ int size;
    private Node first;
    
    /**
     * Constructor.
     */
    //@ ensures \result.size == 0;
    public LinkedList () {
        size = 0;
        first = null;
    }
    
    /**
     * Method add.
     * Adds an element at a certain index in the LinkedList
     * @param index
     * @param element
     */
    public void add(int index, Element element) {
        Node newNode = new Node(element);
        if (index == 0) {
            newNode.next = first;
            first = newNode;
        } else {
            Node p = getNode(index-1);
            newNode.next = p.next;
            p.next = newNode;
        }
        size = size + 1;
    }
    
    /**
     * Method remove.
     * Removes a certain element.
     * @param element
     */
    //@ ensures this.size == \old(size) - 1;
    public void remove(Element element) {
        Node prev = findBefore(element);
        if (prev == null && getElement(0) == element) {
        	first = getNode(0).next;
        } else {
        prev.next = prev.next.next;
        }
        size--;
    }
    
    /**
     * Method findBefore.
     * @param element
     * @return
     */
    public Node findBefore(Element element) {
        if (getElement(0) == element) {
        	return null;
        }
    	int i = 1; 
        while (getElement(i) != element && i < this.size()) {
        	i++; 
        }
    	if (getElement(i) == element) {
    		return getNode(i - 1);
    	}
    	return null;
    }
    
    /**
     * Method getElement.
     * Returns the element of a Node at a certain index
     * @param index
     * @return element
     */
    //@ requires 0 <= index && index < this.size();
    public Element getElement(int index) {
        Node p = getNode(index);
        return p.element;
    }
    
    /**
     * Method getNode.
     * Return the node of a certain index.
     * @param index
     * @return Node
     */
    //@ requires 0 <= i && i < this.size();
    private /*@ pure @*/ Node getNode(int i) {
        Node p = first;
        int pos = 0;
        while (pos != i) {
            p = p.next;
            pos = pos + 1;
        }
        return p;
    }
    
    /**
     * Method size.
     * @return the size of a LinkedList
     */
    //@ ensures \result >= 0;
    public /*@ pure @*/ int size() {
        return size;
    }

    public class Node {
        private Element element;
        public Node next;

        public Node(Element element) {
            this.element = element;
            this.next = null;
        }

        public Element getElement() {
            return element;
        }
    }
}
