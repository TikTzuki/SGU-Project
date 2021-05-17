package hanoitower;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import infrastructure.Snapshot;
import infrastructure.State;
import infrastructure.Vertex;

public class UsingAstar {
	public static Integer identityIncreasing = 0;
	public List<Vertex> OPEN = new ArrayList<Vertex>() {
		public boolean contains(Object o) {
			Vertex v = (Vertex) o;
			for(Vertex Vertex: this) {
				if(Vertex.state.isSameState(v.state)) {
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
	HaiNoiTowerState goal = new HaiNoiTowerState(new int[]{3,3,3});
	
	public UsingAstar(){
		this.identityIncreasing = 0;
	}
	
	public void resolve() {
		State<HaiNoiTowerState> initState = new HaiNoiTowerState(new int[] {1,1,1});
		Vertex<HaiNoiTowerState> initVertex = new Vertex<HaiNoiTowerState>(0, initState, 0, 0);
		// Update h,f
		initVertex.calVertexCost(goal);
		OPEN.add(initVertex);
		int limit = 36;
		while(!checkSuccess() && this.OPEN.size() != 0 && limit > 0) {
			Vertex smallest = OPEN.remove(0);
			List<Vertex> newVertexs = smallest.movation(OPEN, goal, identityIncreasing);
			OPEN.addAll(newVertexs);
			identityIncreasing+=newVertexs.size();
			Collections.sort(OPEN, compareVertexF);
			CLOSE.add(smallest);
			this.snapshots.add(new Snapshot(OPEN, newVertexs, CLOSE, smallest));
			limit --;
		}
		System.out.println("CLOSE : ");
		CLOSE.forEach(System.out::println);
		System.out.println("\t###########\nFINISH");
		System.out.println(CLOSE.get(CLOSE.size()-1).toString());
	}
	
	public static void main(String[] args) {
		UsingAstar a = new UsingAstar();
		a.resolve();
	}
	
	private boolean checkSuccess() {
		return CLOSE.size() > 0 && CLOSE.get(CLOSE.size()-1).state.isSameState(goal) ? true: false;
	}
	
	public List<Snapshot> snapshots = new ArrayList<Snapshot>();
}