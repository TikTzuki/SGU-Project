package app;

import java.util.Vector;

public class Stack extends Vector {
	
	public Stack(){
	}
	
	
	public boolean isEmpty() {
		return elementCount == 0;
	}
	
	public Object peek() {
		if(elementCount == 0)
			return null;
		return elementData[elementCount - 1];
	}
	
	public Object pop() {
		Object obj = null;
		if( elementCount == 0)
			return obj;

		obj = elementData[--elementCount];
		elementData[elementCount] = null;
		return obj;
	}
	
	public Object push(Object element) {
		addElement(element);
		return element;
	}
	
	public int search(Object obj) {
		int i = elementCount;
		while( --i >= 0)
			if(obj.equals(elementData[i]))
				return elementCount - i;
		return -1;
	}
	
	//Test
	/*
    public static void main(String[] args) {
    	Stack st = new Stack();
    	st.push("first");
    	st.push("second");
    	st.push("third");
    	System.out.println(st.peek());
    	st.pop();
    	System.out.println(st.peek());
    }
    */
}
