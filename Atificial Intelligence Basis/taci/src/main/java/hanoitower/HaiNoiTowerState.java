package hanoitower;

import java.util.ArrayList;
import java.util.List;

import infrastructure.State;
import lombok.Data;

@Data
public class HaiNoiTowerState implements State<HaiNoiTowerState> {
	public int[] disks;

	public HaiNoiTowerState(int[] disks) {
		this.disks = disks;
	}

	public HaiNoiTowerState() {
	}

	public List<State<HaiNoiTowerState>> movation() {
		List<State<HaiNoiTowerState>> states = new ArrayList<State<HaiNoiTowerState>>();
		switch (this.findStateForm()) {
		case 1:
			states.addAll(moveDiskCase1());
			break;
		case 2:
			states.addAll(moveDiskCase2());
			break;
		default:
			states.addAll(moveDiskCase3());
			break;
		}
		return states;
	}

	@Override
	public boolean isSameState(HaiNoiTowerState state) {
		if(this.disks[0]==state.disks[0]
				&& this.disks[1]==state.disks[1]
						&& this.disks[2]==state.disks[2])
			return true;
		return false;
	}

	@Override
	public int calStateCost(HaiNoiTowerState goalState) {
		int h = 3;
		for(int i=0; i<this.disks.length; i++) {
			if(this.disks[i]==3) {
				h--;
			}
		}
		return h;
	}
	
	private int findStateForm(){
		if(this.disks[0] == this.disks[1] && this.disks[1] == this.disks[2]) {
			return 1;
		}
		if(this.disks[0] != this.disks[1] && this.disks[1] != this.disks[2]) {
			return 3;
		}
		return 2;
	}

	List<State<HaiNoiTowerState>> moveDiskCase1(){
		List<State<HaiNoiTowerState>> newStates = new ArrayList<State<HaiNoiTowerState>>();
		switch (this.disks[2]) {
		case 1:
			newStates.add(new HaiNoiTowerState(new int[]{1,1,2}));
			newStates.add(new HaiNoiTowerState(new int[] {1,1,3}));
			break;
		case 2:
			newStates.add(new HaiNoiTowerState(new int[]{2,2,3}));
			newStates.add(new HaiNoiTowerState(new int[] {2,2,1}));
			break;
		case 3:
			newStates.add(new HaiNoiTowerState(new int[]{3,3,1}));
			newStates.add(new HaiNoiTowerState(new int[] {3,3,2}));
			break;
		}
		return newStates;
	}
	
	List<State<HaiNoiTowerState>> moveDiskCase2(){
		List<State<HaiNoiTowerState>> newStates = new ArrayList<State<HaiNoiTowerState>>();
		switch(this.disks[2]){
		case 1:
			newStates.add(new HaiNoiTowerState(new int[] {this.disks[0], this.disks[1], 2}));
			newStates.add(new HaiNoiTowerState(new int[] {this.disks[0], this.disks[1], 3}));
			break;
		case 2:
			newStates.add(new HaiNoiTowerState(new int[] {this.disks[0], this.disks[1] , 1}));
			newStates.add(new HaiNoiTowerState(new int[] {this.disks[0], this.disks[1] , 3}));
			break;
		case 3:
			newStates.add(new HaiNoiTowerState(new int [] {this.disks[0], this.disks[1] , 1}));
			newStates.add(new HaiNoiTowerState(new int [] {this.disks[0], this.disks[1] , 2}));
			break;
		}
		if(this.disks[0] == this.disks[1]){
			int temp = 1;
			for (int i = 1; i <= 3; i++) {
				if (temp == this.disks[0] || temp == this.disks[2]) {
					temp++;
				}
			}
			newStates.add(new HaiNoiTowerState(new int[] { this.disks[0], temp ,this.disks[2]}));
		}
		if(this.disks[0]==this.disks[2]){
			int temp = 1;
			for(int i=1; i<=3; i++){
				if(temp == this.disks[0] || temp == this.disks[2]){
					temp++;
				}
			}
			newStates.add(new HaiNoiTowerState(new int[] { this.disks[0], temp ,this.disks[2]}));
		}
		if(this.disks[1]==this.disks[2]){
			int temp = 1;
			for(int i=1; i<=3; i++){
				if(temp == this.disks[0] || temp == this.disks[1]){
					temp++;
				}
			}
			newStates.add(new HaiNoiTowerState(new int[] {temp, this.disks[1], this.disks[2]}));
		}
		return newStates;
	}

	List<State<HaiNoiTowerState>> moveDiskCase3(){
		List<State<HaiNoiTowerState>> newStates = new ArrayList<State<HaiNoiTowerState>>();
		for(int i=1; i<=3; i++){
			if(this.disks[2]!=i){
				newStates.add(new HaiNoiTowerState(new int[] {this.disks[0], this.disks[1], i}));
			}
		}
		newStates.add(new HaiNoiTowerState(new int[] {this.disks[0], this.disks[0], this.disks[2]}));
		return newStates;
	}
}
