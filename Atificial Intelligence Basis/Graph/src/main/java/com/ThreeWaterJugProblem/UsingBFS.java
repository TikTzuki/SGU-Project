package com.ThreeWaterJugProblem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;

public class UsingBFS {
	public static int MAX_JUG1, MAX_JUG2, MAX_JUG3, GOAL;
	public static Queue<Vertex> queue = new LinkedList<Vertex>();
	public static Set<Vertex> visited = new HashSet<Vertex>() {
		public boolean contains(Object o) {
			Vertex vertex = (Vertex) o;
			
			for(Vertex v: this) {
				if((vertex.equals(v)) /*&& (vertex.getPath().equals(v.getPath()))*/) {
					return true;
				}
			}
			return false;
		};
	};
	
	public static void main(String[] args) {
		MAX_JUG1 = 3; MAX_JUG2 = 5; MAX_JUG3 = 9; GOAL = 7;
		
		Vertex.setMAxJugsCapacity(MAX_JUG1, MAX_JUG2, MAX_JUG3);
		
		Vertex initialVertex = new Vertex(new State(0,0,0));
		queue.add(initialVertex);
		visited.add(initialVertex);
		
		while(!queue.isEmpty()) {
			Vertex currentVertex = queue.poll();
			currentVertex.addToPath();
			
			if(currentVertex.getState().getJug1() == GOAL || currentVertex.getState().getJug2() == GOAL || currentVertex.getState().getJug3() == GOAL) {
				currentVertex.printPath();
//				break;
			}
			
			List<Vertex> n = new ArrayList<Vertex>();
			n.add(currentVertex.fullJug1());
			n.add(currentVertex.fullJug2());
			n.add(currentVertex.fullJug3());
			n.add(currentVertex.emptyJug1());
			n.add(currentVertex.emptyJug2());
			n.add(currentVertex.emptyJug3());
			n.add(currentVertex.pourJug1Jug2());
			n.add(currentVertex.pourJug1Jug3());
			n.add(currentVertex.pourJug2Jug1());
			n.add(currentVertex.pourJug2Jug3());
			n.add(currentVertex.pourJug3Jug1());
			n.add(currentVertex.pourJug3Jug2());
			
			for(Vertex newVertex : n) {
//				System.out.println(n)
				if(!visited.contains(newVertex)) {
					newVertex.setPath(currentVertex.getPath());
					queue.add(newVertex);
					visited.add(newVertex);
				}
			}
		}
	}
}
