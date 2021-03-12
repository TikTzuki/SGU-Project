package com.ThreeWaterJugProblem;

import java.util.ArrayList;
import java.util.List;

public class Path<T> {
	private List<T> path;
	
	public Path() {
		path = new ArrayList<>();
	}
	
	public void addVertex(T vetex) {
		path.add(vetex);
	}
	
	public List<T> getPath(){
		return path;
	}

	public void setPath(List<T> path) {
		this.path.addAll(path);
	}
	
	public void printPath() {
//		for(T t: path) {
//			System.out.print(t.toString() + " ");
//		}
		for(int i=0; i<path.size(); i++) {
			System.out.print(path.get(i).toString() + " ");
		}
		System.out.println();
	}
}
