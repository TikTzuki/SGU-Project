package app;

import java.util.Collections;
import java.util.Vector;

public class Queue extends Vector{

	public Queue() {
	}
	
	public boolean addAll(Queue q) {
		if(q == this)
			return false;
		for(Object obj : q) {
			addElement(obj);
		}
		return true;
	}
	
	public void clearAll() {
		this.clear();
	}
	
	public boolean add(Object obj) {
		if(obj == null)
			return false;
		addElement(obj);
		return true;
	}
	public boolean remove() {
		
		if( elementCount == 0)
			return false;
		this.remove(0);
			return true;
	}
	
	//Test
	
	/*
    public static void main(String[] args) {

    	
    	Queue que = new Queue();
    	que.add("first");
    	que.add("second");
    	que.add("third");
    	System.out.println(que);
    	que.remove();
    	System.out.println(que);
    	que.clearAll();
    	System.out.println(que);
    } 
    */
}
