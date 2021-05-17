package taci;

import java.text.Format;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import infrastructure.State;
import lombok.Data;
import lombok.ToString;

@Data
public class EightPuzzle implements State<EightPuzzle> {
	public int[][] matrix;
	
	public EightPuzzle(int[][] matrix) {
		this.matrix = matrix;
	}
	
	public EightPuzzle() {
	}
	
	@Override
	public List<State<EightPuzzle>> movation() {
		// Find location of zero
		int i=0, j=0;
		loop:
		for(i=0; i<3; i++) {
			for(j=0; j<3; j++) {
				if(this.matrix[i][j] == 0) {
					break loop;
				}
			}
		}
		// Create new states
		List<State<EightPuzzle>> states = new ArrayList<State<EightPuzzle>>(); 
		if(i+1 < 3) {
			EightPuzzle newState = this.createNewState(i, j, i+1, j);
			if(!this.isSameState(newState)) {
				states.add(newState);
			}
		}
		if(i-1 >= 0) {
			EightPuzzle newState = this.createNewState(i, j, i-1, j);
			if(!this.isSameState(newState)) {
				states.add(newState);
			}
		}
		if(j+1 < 3) {
			EightPuzzle newState = this.createNewState(i, j, i, j+1);
			if(!this.isSameState(newState)) {
				states.add(newState);
			}
		}
		if(j-1 >= 0) {
			EightPuzzle newState = this.createNewState(i, j, i, j-1);
			if(!this.isSameState(newState)) {
				states.add(newState);
			}
		}
		return states;
	}

	@Override
	public boolean isSameState(EightPuzzle state) {
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(state.matrix[i][j] != this.matrix[i][j])
					return false;
			}
		}
		return true;
	}

	@Override
	public int calStateCost(EightPuzzle goalState) {
		int totalCost = 0;
		for(int i=0; i<=8; i++) {
			totalCost += calCost(this.getLocationX(i), this.getLocationY(i), goalState.getLocationX(i), goalState.getLocationY(i));
		}
		return totalCost;
	}

	private int calCost(int x,int y,int targetX,int targetY){
		if (x == targetX) {
			if (y == targetY + 1 || y == targetY - 1)
				return 1;
			if (y == targetY + 2 || y == targetY - 2)
				return 2;
			if (y == targetY)
				return 0;
		}
		if (x == targetX + 1 || x == targetX - 1) {
			if (y == targetY)
				return 1;
			if (y == targetY + 1 || y == targetY - 1)
				return 2;
			if (y == targetY + 2 || y == targetY - 2)
				return 3;
		}

		if (y == targetX + 2 || x == targetX - 2) {
			if (y == targetY)
				return 2;
			if (y == targetY + 1 || y == targetY - 1)
				return 3;
			if (y == targetY + 2 || y == targetY - 2)
				return 4;
		}
		return 0;
	}
	
	public int getLocationX(int value) {
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(this.matrix[i][j] == value)
					return i;
			}
		}
		return 0;
	}
	
	public int getLocationY(int value) {
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(this.matrix[i][j] == value)
					return j;
			}
		}
		return 0;
	}
	
	private EightPuzzle createNewState(int currentX, int currentY,int targetX, int  targetY) {
		EightPuzzle newState = null;
		newState = this.clone();
		newState.switchMatrix(newState.matrix, currentX, currentY, targetX, targetY);
		return newState;
	}

	private int[][] switchMatrix(int[][] matrix, int i, int j, int k , int l){
		int temp = matrix[k][l];
		matrix[k][l] = 0;
		matrix[i][j] = temp;
		return matrix;
	}

	@Override
	public String toString() {
		return "EightPuzzle {matrix= \n"
				+ Arrays.toString(this.matrix[0]) +"\n"
				+ Arrays.toString(this.matrix[1]) +"\n"
				+ Arrays.toString(this.matrix[2]) +" }";
	}
	
	@Override
	protected EightPuzzle clone() {
		int[][] matrix = new int[this.matrix.length][this.matrix[0].length];
		for(int i=0; i<this.matrix.length; i++) {
			for(int j=0; j<this.matrix[i].length; j++) {
				matrix[i][j] = this.matrix[i][j];
			}
		}
		return new EightPuzzle(matrix);
	}
}
