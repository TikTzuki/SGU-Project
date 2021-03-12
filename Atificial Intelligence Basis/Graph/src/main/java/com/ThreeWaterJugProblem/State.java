package com.ThreeWaterJugProblem;

public class State {
	private int jug1, jug2, jug3;
	private static int MAX_JUG1 = 0;
	private static int MAX_JUG2 = 0;
	private static int MAX_JUG3 = 0;
	
	public State() {
		this.jug1 = 0;
		this.jug2 = 0;
		this.jug3 = 0;
	}

	public State(int jug1, int jug2, int jug3) {
		this.jug1 = jug1;
		this.jug2 = jug2;
		this.jug3 = jug3;
	}
	
	public static void setMaxJugsCapacity(int maxJug1, int maxJug2, int maxJug3) {
		MAX_JUG1 = maxJug1;
		MAX_JUG2 = maxJug2;
		MAX_JUG3 = maxJug3;
	}

	public State fullJug1() {
		return new State(MAX_JUG1, jug2, jug3);
	}
	
	public State fullJug2() {
		return new State(jug1, MAX_JUG2, jug3);
	}
	
	public State fullJug3() {
		return new State(jug1, jug2, MAX_JUG3);
	}
	
	public State emptyJug1() {
		return new State(0, jug2, jug3);
	}
	
	public State emptyJug2() {
		return new State(jug1, 0, jug3);
	}
	
	public State emptyJug3() {
		return new State(jug1, jug2, 0);
	}
	
	public State pourJug1Jug2() {
		if((jug1+jug2) >= MAX_JUG2)
			return new State((jug1 + jug2 - MAX_JUG2), MAX_JUG2, jug3);
		else
			return new State(0, (jug1+jug2), jug3);
	}
	
	public State pourJug1Jug3() {
		if((jug1 + jug3) >= MAX_JUG3)
			return new State((jug1 + jug3 - MAX_JUG3), jug2, MAX_JUG3);
		else
			return new State(0, jug2, (jug1+jug3));
	}
	
	public State pourJug2Ju1() {
		if((jug1+jug2) >= MAX_JUG1)
			return new State(MAX_JUG1, (jug1+jug2-MAX_JUG1), jug3);
		else
			return new State((jug1+jug2), 0, jug3);
	}
	
	public State pourJug2Jug3() {
		if((jug2+jug3) >= MAX_JUG3)
			return new State(jug1, (jug2+jug3-MAX_JUG3), MAX_JUG3);
		else
			return new State(jug1, 0, (jug2+jug3));
	}
	
	public State pourJug3Jug1() {
		if((jug1+jug3) >= MAX_JUG1)
			return new State(MAX_JUG1, jug2, (jug1+jug3-MAX_JUG1));
		else
			return new State((jug1+jug3), jug2, 0);
	}
	
	public State pourJug3Jug2() {
		if((jug2+jug3) >= MAX_JUG2)
			return new State(jug1, MAX_JUG2, (jug2+jug3-MAX_JUG2));
		else
			return new State(jug1, (jug2+jug3), 0);
	}
	
	@Override
	public boolean equals(Object obj) {
		State s= (State) obj;
		if(!(s instanceof State))
			return false;
		return ((s.getJug1() == this.getJug1()) && (s.getJug2() == this.getJug2()) && (s.getJug3() == this.getJug3()));
	}
	
	@Override
	public String toString() {
		return "(" + jug1 + "-" +jug2 + "-" + jug3 + ")";
	}
	
	public int getJug1() {
		return jug1;
	}

	public void setJug1(int jug1) {
		this.jug1 = jug1;
	}

	public int getJug2() {
		return jug2;
	}

	public void setJug2(int jug2) {
		this.jug2 = jug2;
	}

	public int getJug3() {
		return jug3;
	}

	public void setJug3(int jug3) {
		this.jug3 = jug3;
	}

	
}
