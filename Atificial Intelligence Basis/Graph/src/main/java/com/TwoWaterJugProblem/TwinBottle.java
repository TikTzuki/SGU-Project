package com.TwoWaterJugProblem;

public class TwinBottle implements Cloneable {
	Integer bottle1;
	Integer maximunBottle1;
	Integer bottle2;
	Integer maximunBottle2;
	Integer expectedResult;
	
	@Override
	protected Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
	public TwinBottle() {
		super();
	}

	public TwinBottle(Integer bottle1, Integer maximunBottle1, Integer bottle2, Integer maximunBottle2,
			Integer expectedResult) {
		super();
		this.bottle1 = bottle1;
		this.maximunBottle1 = maximunBottle1;
		this.bottle2 = bottle2;
		this.maximunBottle2 = maximunBottle2;
		this.expectedResult = expectedResult;
	}

	public TwinBottle full1() {
		TwinBottle b = (TwinBottle) this.clone();
//		TwinBottle b =  this;
		b.setBottle1(this.maximunBottle1);
		return b;
	}
	
	public TwinBottle full2() {
		TwinBottle b = (TwinBottle) this.clone();
//		TwinBottle b = this;
		b.setBottle2(this.maximunBottle2);
		return b;
	}
	
	public TwinBottle empty1() {
		TwinBottle b = (TwinBottle) this.clone();
//		TwinBottle b = this;
		b.setBottle1(0);
		return b;
	}
	
	public TwinBottle empty2() {
		TwinBottle b = (TwinBottle) this.clone();
//		TwinBottle b = this;
		b.setBottle2(0);
		return b;
	}
	
	public TwinBottle pour1to2() {
		TwinBottle b = (TwinBottle) this.clone();
		while(b.bottle1>0 && b.bottle2<b.maximunBottle2) {
			b.bottle1-=1;
			b.bottle2+=1;
		}
		return b;
	}
	
	public TwinBottle pour2to1() {
		TwinBottle b = (TwinBottle) this.clone();
//		TwinBottle b = this;
		while(b.bottle2>0 && b.bottle1<b.maximunBottle1) {
			b.bottle2-=1;
			b.bottle1+=1;
		}
		return b;
	}

	public Integer getBottle1() {
		return bottle1;
	}

	public void setBottle1(Integer bottle1) {
		this.bottle1 = bottle1;
	}

	public Integer getBottle2() {
		return bottle2;
	}

	public void setBottle2(Integer bottle2) {
		this.bottle2 = bottle2;
	}
	@Override
	public boolean equals(Object obj) {
		TwinBottle b = (TwinBottle) obj;
		if(!(b instanceof TwinBottle))
			return false;
		return this.bottle1==b.bottle1 && this.bottle2==b.bottle2;
	}
	public boolean equals(TwinBottle obj) {
		System.out.println("equal from me");
		if(this.bottle1==obj.bottle1 && this.bottle2==obj.bottle2) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "{b1 : " + bottle1 + ", b2 : " + bottle2+"}";
	}
}
