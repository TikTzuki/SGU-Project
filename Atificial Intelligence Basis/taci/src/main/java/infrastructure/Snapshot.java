package infrastructure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import lombok.Data;

@Data
public class Snapshot {
	public List<Vertex> open = new ArrayList<Vertex>();
	public String openToString ="";
	public List<Vertex> newOpens = new ArrayList<Vertex>();
	public List<Vertex> close = new ArrayList<Vertex>();
	public String closeToString = "";
	Vertex v;
	String initString;
	String finishString;
	
	public Snapshot(List<Vertex> oPEN, List<Vertex> newOPEN, List<Vertex> cLOSE, Vertex v) {
		open = oPEN;
		Iterator<Vertex> itr = newOPEN.iterator();
		while(itr.hasNext()) {
			this.newOpens.add((Vertex) itr.next().clone());
		}
		close = cLOSE;
		this.v = v;
		this.initString = "Lay S" + v.identity + " ra khoi OPEN";
		this.finishString = "Them " + newOpenToString() + " vao OPEN. \n Them S"+v.identity + " vao CLOSE";
		this.openToString = openToString();
		this.closeToString = closeToString();
	}
	
	public Snapshot(List<Vertex> oPEN, List<Vertex> newOPEN, List<Vertex> cLOSE, Vertex v, String initString,
			String finishString) {
		open = oPEN;
		this.newOpens = newOPEN;
		close = cLOSE;
		this.v = v;
		this.initString = initString;
		this.finishString = finishString;
		this.finishString = "Them " + newOpenToString() + " vao OPEN. \n Them S"+v.identity + "vao CLOSE";
	}
	
	String newOpenToString() {
		String result = "";
		for(Vertex v: newOpens) {
			result += "S"+v.identity+", ";
		}
		return result.substring(0, result.lastIndexOf(",")!=-1?result.lastIndexOf(","):0);
	}
	
	String openToString() {
		for(Vertex openTemp : open) {
			openToString += "S"+openTemp.identity +", ";
		}
		return this.openToString.substring(0, openToString.lastIndexOf(","));
	}

	String closeToString() {
		for(Vertex closeTemp : close) {
			closeToString += "S"+closeTemp.identity +", ";
		}
		return this.closeToString.substring(0, closeToString.lastIndexOf(","));
	}
}
