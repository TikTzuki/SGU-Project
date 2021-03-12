package com.TwoWaterJugProblem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.Vector;

public class UsingBFS {
    public static int MAX_JUG1, MAX_JUG2, GOAL;
    public static Queue<Vertex> queue = new LinkedList<Vertex>();
    public static Set<Vertex> visited = new HashSet<Vertex>() {
    	public boolean contains(Object o) {
    		Vertex vertex = (Vertex) o;
    		
    		for(Vertex v: this) {
    			if((vertex.equals(v)) && (vertex.getPath().equals(v.getPath()))) {
    				return true;
    			}
    		}
    		return false;
    	};
    };
    
    public static void main(String[] args) {
    	MAX_JUG1 = 3;
    	MAX_JUG2 = 4;
    	GOAL = 2;
    	
    	Vertex.setMaxJugsCapacity(MAX_JUG1, MAX_JUG2);
    	
    	Vertex initialVertex = new Vertex(new State(0,0));
    	queue.add(initialVertex);
    	visited.add(initialVertex);
    	
    	while(!queue.isEmpty()) {
    		Vertex currentVertex = queue.poll();
    		currentVertex.addToPath();
    		
    		if(currentVertex.getState().getJug1() == GOAL || currentVertex.getState().getJug2() == GOAL) {
    			currentVertex.printPath();
    			break;
    		}
    		
    		ArrayList<Vertex> newVertices = new ArrayList<Vertex>();
            newVertices.add(currentVertex.full_jug1());
            newVertices.add(currentVertex.full_jug2());
            newVertices.add(currentVertex.empty_jug1()); 
            newVertices.add(currentVertex.empty_jug2());                        
            newVertices.add(currentVertex.pour_jug1_jug2());
            newVertices.add(currentVertex.pour_jug2_jug1());
            
            for (Vertex newVertex : newVertices){                                    
                if(!visited.contains(newVertex)){                        
                    newVertex.setPath(currentVertex.getPath());
                    queue.add(newVertex);                   
                    visited.add(newVertex);                                        
                }                                             
            }
    	}
	}
}
