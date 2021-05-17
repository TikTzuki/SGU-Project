package infrastructure;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Vertex<T> implements Cloneable {
	public int identity;
	public State<T> state;
	public int g;
	public int h;
	public int f;
	int parentIdentity;

	public Vertex(int g, int h, int f, State<T> state, int identity, int parentIdentity) {
		this.g = g;
		this.h = h;
		this.f = f;
		this.state = state;
		this.identity = identity;
		this.parentIdentity = parentIdentity;
	}
	
	public Vertex(int g, State<T> state, int identity, int parentIdentity) {
		this.g = g;
		this.state = state;
		this.identity = identity;
		this.parentIdentity = parentIdentity;
	}
	
	public void calVertexCost(T goalState){
		this.h = this.state.calStateCost(goalState);
		this.f = this.g + this.h;
	}
	
	public List<Vertex<T>> movation(List<Vertex> OPEN, T goal, int identity){
		List<Vertex<T>> vertexs = new ArrayList<Vertex<T>>();
		List<State<T>> newStates = this.state.movation();
		for(State<T> state: newStates) {
			Vertex<T> newVertex = new Vertex<T>(this.g+1, state, identity+1, this.identity);
			newVertex.calVertexCost(goal);
			if(OPEN.indexOf(newVertex) != -1) {
				Vertex openV = OPEN.get(OPEN.indexOf(newVertex));
				// Update 
				if(newVertex.f > openV.f) {
					openV.g = newVertex.g;
					openV.h = newVertex.h;
					openV.f = newVertex.f;
				}
			} else {
				identity++;
				vertexs.add(newVertex);
			}
		}
		return vertexs;
	}
	
	public void printVertex() {
		System.out.println("id: " + this.identity);
		System.out.println("g: "+this.g);
		System.out.println("h: "+this.h);
		System.out.println("f: "+this.f);
		System.out.println("parent: " +this.parentIdentity);
		System.out.println(this.state);
	}
	
	@Override
	public String toString() {
		return "\nid: " + this.identity
				+"\ng: " + this.g
				+"\nh: " + this.h
				+"\n f: " + this.f
				+"\nparent: " + this.parentIdentity
				+ "\n"+this.state;
	}
	
	@Override
	public Object clone() {
		Vertex clone = null;
		try {
			clone = (Vertex) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		clone.setG(this.g);
		clone.setH(this.h);
		clone.setF(this.f);
		clone.setState(this.state);
		return clone;
	}
}
