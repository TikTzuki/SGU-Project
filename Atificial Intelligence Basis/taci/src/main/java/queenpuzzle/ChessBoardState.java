package queenpuzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import infrastructure.State;

public class ChessBoardState implements State<ChessBoardState>{
	public int[] queens;
	
	public ChessBoardState(int[] queens) {
		this.queens = queens;
	}

	public ChessBoardState() {
		
	}
	
	@Override
	public List<State<ChessBoardState>> movation() {
		List<State<ChessBoardState>> newStates = new ArrayList<State<ChessBoardState>>();
		for(int i=0 ; i<queens.length ; i++) {
			int[] queens = new int[this.queens.length];
			ChessBoardState newState = new ChessBoardState();
			for(int j=0; j<queens.length; j++) {
				if(i==j) {
					queens[j] = this.queens[j]+1 < queens.length-1 ? this.queens[j]+1 : queens.length-1;
				}
				else {
					queens[j] = this.queens[j];
				}
				newState.queens = queens;
			}
			newStates.add(newState);
		}
		return newStates;
	}

	@Override
	public boolean isSameState(ChessBoardState state) {
		for(int i=0; i<queens.length; i++) {
			if(this.queens[i] == state.queens[i])
				return false;
		}
		return true;
	}

	@Override
	public int calStateCost(ChessBoardState goalState) {
		int h=0;
		for(int i=0; i<queens.length; i++) {
			for(int j=i+1; j<queens.length; j++) {
				if(queens[i]==queens[j])
					h++;
				if( (queens[i]+i)==(queens[j]+j) || (queens[j]-i==queens[i]-j))
					h++;
			}
		}
		return h;
	}

	@Override
	public String toString() {
		return "ChessBoardState [queens=" + Arrays.toString(queens) + "]";
	}

}

