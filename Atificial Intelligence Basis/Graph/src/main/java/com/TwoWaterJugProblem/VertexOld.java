package com.TwoWaterJugProblem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VertexOld<T> {
	public T state;
	private List<VertexOld<T>> adjacentVertices;
	
	public boolean constrainAdjacent(VertexOld<T> vertex) {
		Iterator<VertexOld<T>> itr = this.adjacentVertices.iterator();
		while(itr.hasNext()) {
			VertexOld<T> v = itr.next();
			if(v.getState().equals(vertex.getState()))
				return true;
		}
		return false;
	}
	
	public VertexOld(T state) {
		this.state = state;
		this.adjacentVertices = new ArrayList<VertexOld<T>>();
	}
	
	public T getState() {
		return state;
	}
	
	public void setState(T state) {
		this.state = state;
	}
	
	public List<VertexOld<T>> getAdjacentVertices(){
		return adjacentVertices;
	}
	
	public void addAdjacentVertex(VertexOld ajdacentVertex) {
		this.adjacentVertices.add(ajdacentVertex);
	}
	
	@Override
	public boolean equals(Object obj) {
		VertexOld<T> vertex = (VertexOld<T>) obj;
		
		if(!(vertex instanceof VertexOld))
			return false;
		return (vertex.getState().equals(this.getState()));
	}
	
	@Override
	public String toString() {
		return "" + this.state;
	}
}
