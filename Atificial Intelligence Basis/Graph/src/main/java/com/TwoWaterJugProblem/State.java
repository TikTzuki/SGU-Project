package com.TwoWaterJugProblem;

public class State {
    private int jug1, jug2;
    private static int MAX_JUG1 = 0;
    private static int MAX_JUG2 = 0;    
    
    public State(){
        this.jug1 = 0;
        this.jug2 = 0;        
    }
    
    public State(int jug1, int jug2){
        this.jug1 = jug1;
        this.jug2 = jug2;        
    }
    
    public static void setMaxJugsCapacity(int maxJug1, int maxJug2){
        MAX_JUG1 = maxJug1;
        MAX_JUG2 = maxJug2;        
    }
    
    public int getJug1(){
        return jug1;
    } 
    
    public int getJug2(){
        return jug2;
    }
    
    public State full_jug1(){
	return new State(MAX_JUG1, jug2);
    }
    
    public State full_jug2(){
	return new State(jug1, MAX_JUG2);
    }
    
    public State empty_jug1(){
	return new State(0, jug2);
    }
    
    public State empty_jug2(){
	return new State(jug1, 0);
    }
    
    public State pour_jug1_jug2(){
        if ((jug1 + jug2) >= MAX_JUG2)
            return new State((jug1 + jug2 - MAX_JUG2), MAX_JUG2);
        else
            return new State(0, (jug1 + jug2));
    }
    
    public State pour_jug2_jug1(){
        if ((jug1 + jug2) >= MAX_JUG1)
            return new State(MAX_JUG1, (jug1 + jug2 - MAX_JUG1));
        else
            return new State((jug1 + jug2), 0);
    }
        
    @Override
    public boolean equals(Object obj) {
        State s = (State) obj;        
        
	if (!(s instanceof State))
            return false;	

        return ((s.getJug1() == this.getJug1()) && (s.getJug2() == this.getJug2()));
    }
    
    @Override
    public String toString(){
        return "(" + jug1 + "-" + jug2 + ")";
    }
}
