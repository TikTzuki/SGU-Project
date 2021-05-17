package taci;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import infrastructure.Snapshot;
import infrastructure.State;
import infrastructure.Vertex;

public class UsingAStartEightPuzzle{
	public static Integer identityIncreasing = 0;
	public List<Vertex> OPEN = new ArrayList<Vertex>() {
		public boolean contains(Object o) {
	Vertex v = (Vertex) o;
			for(Vertex vertex: this) {
				if(vertex.state.isSameState(v.state)) {
					return true;
				}
			}
			return false;
		};

		public int indexOf(Object o) {
			Vertex v = (Vertex) o;
			for(int i=0; i<this.size(); i++) {
				if(this.get(i).state.isSameState(v.state)) {
					return i;
				}
			}
			return -1;
		};
	};
	public List<Vertex> CLOSE = new ArrayList<Vertex>();
	Comparator<Vertex> compareVertexF = new Comparator<Vertex>() {

		@Override
		public int compare(Vertex o1, Vertex o2) {
			int prority1 = 0;
//			if((o1.g - o2.g) < 0) {
//				prority1 = 2;
//			}
//			if((o1.g - o2.g)>0) {
//				prority1 = -2;
//			}

			int prority2 = 0;
			if((o1.f - o2.f) < 0) {
				prority2 = -1;
			}
			if((o1.f - o2.f)>0) {
				prority2 = 1;
			}
			return prority1 + prority2;
		}
	};
	EightPuzzle goal = new EightPuzzle(new int[][]{
				{1,2,3},
				{8,0,4},
				{7,6,5}});
	
	public UsingAStartEightPuzzle(){
		this.identityIncreasing = 0;
	}
	public void resolve() {
		State<EightPuzzle> initState = new EightPuzzle(new int[][] {
			{8,3,4},
			{0,2,1},
			{7,6,5},
		});
		Vertex<EightPuzzle> initVertex = new Vertex<EightPuzzle>(0, initState, 0, 0);
		// Update h, f
		initVertex.calVertexCost(goal);
		OPEN.add(initVertex);
		int limit = 50;
		while(!checkSuccess() && this.OPEN.size() != 0 && limit > 0) {
			Vertex smallest = OPEN.remove(0);
			List<Vertex> newVertes = smallest.movation(OPEN, goal, UsingAStartEightPuzzle.identityIncreasing);
			OPEN.addAll(newVertes);
			identityIncreasing+=newVertes.size();
			Collections.sort(OPEN, compareVertexF);
			CLOSE.add(smallest);
			this.snapshots.add(new Snapshot(OPEN, newVertes, CLOSE, smallest));
			limit --;
		}
	}
	
	boolean checkSuccess() {
		return CLOSE.size()>0 && CLOSE.get(CLOSE.size()-1).state.isSameState(goal) ? true : false ;
	}
	
	public static void main(String[] args) {
		new UsingAStartEightPuzzle().resolve();
	}
	
	public List<Snapshot> snapshots = new ArrayList<Snapshot>();
}