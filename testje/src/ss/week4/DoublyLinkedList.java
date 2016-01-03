package ss.week4;

/**
 * Class DoublyLinkedList.
 * @author Noel
 *
 * @param <Element>
 */
public class DoublyLinkedList<Element> {
    private /*@ spec_public @*/ int size;
    private Node head;
    
    /**
     * Constructor.
     */
    //@ ensures this.size == 0;
    public DoublyLinkedList() {
        size = 0;
        head = new Node(null);
        head.next = head;
        head.previous = head;
    }
    
    /**
     * Method add.
     * Adds an element to the DoublyLinkedList at a certain index
     * @param index, location to add
     * @param element to add
    */
    //@ requires element != null;
    //@ requires 0 <= index && index <= this.size;
    //@ ensures this.size == \old(size) + 1;
    //@ ensures this.getNode(index).equals(element);
    public void add(int index, Element element) {
    	Node newElem = new Node(element);
    	Node current = head;
    	int i = -1;
        if (element != null && 0 <= index && index <= this.size) {
        	while (i < index) {
        		current = current.next;
        		i++;
        	}
        	Node prev = current.previous;
        	newElem.previous = prev;
        	prev.next = newElem;
        	newElem.next = current;
        	current.previous = newElem;
        }
        size++;
    }
    
    /**
     * Method remove.
     * Removes an element at a certain index
     * @param index of the element to be removed
     */
    //@ requires 0 <= index && index < this.size;
    //@ ensures this.size == \old(size) - 1;
    public void remove(int index) {
    	Node current = head;
        int i = -1;
        while (i < index) {
        	current = current.next;
        	i++;
        }
        Node prev = current.previous;
        Node next = current.next;
        prev.next = next;
        next.previous = prev;
        size--;
    }
    
    /**
     * Method getElement.
     * Returns the element at a certain index
     * @param index
     * @return element
     */
    //@ requires 0 <= index && index < this.size;
    /*@ pure */
    public Element getElement(int index) {
        Node p = getNode(index);
        return p.element;
    }

    /**
     * Method getNode.
     * The node containing the element with the specified index.
     * The head node if the specified index is -1.
     * @return Node
     */
    //@ requires -1 <= i && i < this.size;
    //@ pure
    public Node getNode(int i) {
        Node p = head;
        int pos = -1;
        while (pos < i) {
            p = p.next;
            pos = pos + 1;
        }
        return p;
    }
    
    /**
     * Method size.
     * Returns the size of a DoulbeLinkedList
     * @return int
     */
    public int size() {
        return this.size;
    }
    
    public class Node {
        public Node(Element element) {
            this.element = element;
            this.next = null;
            this.previous = null;
        }

        private Element element;
        public Node next;
        public Node previous;

        public Element getElement() {
            return element;
        }
    }
}
