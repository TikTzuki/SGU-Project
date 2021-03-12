package com.TwoWaterJugProblem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class UsingDFS {
	public static int MAX_JUG1, MAX_JUG2, GOAL;
	public static Stack<Vertex> stack = new Stack<Vertex>();
	public static Set<Vertex> visited = new HashSet<Vertex>() {
		public boolean contains(Object o) {
			Vertex vertex = (Vertex) o;
			for(Vertex v: this) {
				if((vertex.equals(v)))
					return true;
			}
			return false;
		}
	};
	
	public static void main(String[] args) {
		MAX_JUG1 = 3; MAX_JUG2 = 4; GOAL = 2;
		
		Vertex.setMaxJugsCapacity(MAX_JUG1, MAX_JUG2);
		Vertex initialVertex = new Vertex(new State(0,0));
		
		stack.push(initialVertex);
		visited.add(initialVertex);
		int i=0;
		while(!stack.empty()) {
			Vertex currentVertex = stack.pop();
			currentVertex.addToPath();
			if(currentVertex.getState().getJug1() == GOAL || currentVertex.getState().getJug2() == GOAL) {
				currentVertex.printPath();
			}
			
			List<Vertex> n = new ArrayList<Vertex>();
			n.add(currentVertex.full_jug1());
			n.add(currentVertex.full_jug2());
			n.add(currentVertex.empty_jug1());
			n.add(currentVertex.empty_jug2());
			n.add(currentVertex.pour_jug1_jug2());
			n.add(currentVertex.pour_jug2_jug1());
			
			for(Vertex newVertex : n) {
				if(!visited.contains(newVertex)) {
					newVertex.setPath(currentVertex.getPath());
					stack.push(newVertex);
					visited.add(newVertex);
				}
			}
		}
	}
}
