package com.TwoWaterJugProblem;

import java.util.List;

public class Vertex {
	 private State state;
	    private Path<Vertex> path;
	    
	    public Vertex(){
	        this.state = new State();
	        this.path = new Path<>();
	    }
	    
	    public Vertex(State state){
	        this.state = state;        
	        this.path = new Path<>();
	    }
	    
	    public static void setMaxJugsCapacity(int maxJug1, int maxJug2){
	        State.setMaxJugsCapacity(maxJug1, maxJug2);
	    }
	    
	    public State getState(){
	        return state;
	    }        
	    
	    public Vertex full_jug1(){
		return new Vertex(state.full_jug1());
	    }
	    
	    public Vertex full_jug2(){
		return new Vertex (state.full_jug2());
	    }
	    
	    public Vertex empty_jug1(){
		return new Vertex(state.empty_jug1());
	    }
	    
	    public Vertex empty_jug2(){
		return new Vertex(state.empty_jug2());
	    }
	    
	    public Vertex pour_jug1_jug2(){
	        return new Vertex(state.pour_jug1_jug2());
	    }
	    
	    public Vertex pour_jug2_jug1(){
	        return new Vertex(state.pour_jug2_jug1());
	    }
	    
	    public void addToPath() {
	        this.path.addVertex(this);
	    }
	    
	    public List<Vertex> getPath(){
	        return path.getPath();
	    }
	    
	    public void setPath(List<Vertex> path){
	        this.path.setPath(path);
	    }

	    public void printPath(){
	        path.printPath();
	    }        

	    @Override
	    public boolean equals(Object obj) {
	        Vertex v = (Vertex) obj;        
	        
		if (!(v instanceof Vertex))
	            return false;	
	        return (this.getState().equals(v.getState()));
	    }        
	    
	    @Override
	    public String toString(){
	        return state.toString();
	    }
	    
	    
}
