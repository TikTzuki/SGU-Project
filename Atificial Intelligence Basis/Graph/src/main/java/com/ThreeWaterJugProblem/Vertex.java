package com.ThreeWaterJugProblem;

import java.util.List;

public class Vertex {
	private State state;
	private Path<Vertex> path;
	
	public Vertex() {
		this.state = new State();
		this.path = new Path<Vertex>();
	}
	
	public Vertex(State state) {
		this.state = state;
		this.path = new Path<Vertex>();
	}
	
	public static void setMAxJugsCapacity(int maxJug1, int maxJug2, int maxJug3) {
		State.setMaxJugsCapacity(maxJug1, maxJug2, maxJug3);
	}
	
	public State getState() {
		return state;
	}
	
	public Vertex fullJug1() {
		return new Vertex(state.fullJug1());
	}
	
	public Vertex fullJug2() {
		return new Vertex(state.fullJug2());
	}
	
	public Vertex fullJug3() {
		return new Vertex(state.fullJug3());
	}
	
	public Vertex emptyJug1() {
		return new Vertex(state.emptyJug1());
	}
	
	public Vertex emptyJug2() {
		return new Vertex(state.emptyJug2());
	}
	
	public Vertex emptyJug3() {
		return new Vertex(state.emptyJug3());
	}
	
	public Vertex pourJug1Jug2() {
		return new Vertex(state.pourJug1Jug2());
	}
	
	public Vertex pourJug1Jug3() {
		return new Vertex(state.pourJug1Jug3());
	}
	
	public Vertex pourJug2Jug1() {
		return new Vertex(state.pourJug2Ju1());
	}
	
	public Vertex pourJug2Jug3() {
		return new Vertex(state.pourJug2Jug3());
	}
	
	public Vertex pourJug3Jug1() {
		return new Vertex(state.pourJug3Jug1());
	}
	
	public Vertex pourJug3Jug2() {
		return new Vertex(state.pourJug3Jug2());
	}
	
	@Override
	public boolean equals(Object obj) {
		Vertex v= (Vertex) obj;
		
		if(!(v instanceof Vertex))
			return false;
		return (this.getState().equals(v.getState()));
	}

	@Override
	public String toString() {
		return state.toString();
	}

	public List<Vertex> getPath() {
		return path.getPath();
	}

	public void setPath(List<Vertex> path) {
		this.path.setPath(path);
	}
	
	public void addToPath() {
		this.path.addVertex(this);
	}
	
	public void printPath() {
		path.printPath();
	}
}
