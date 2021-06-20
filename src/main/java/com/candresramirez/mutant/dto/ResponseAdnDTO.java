package com.candresramirez.mutant.dto;

public class ResponseAdnDTO {
	
	private boolean mutant;
	private int countMutant;
	private int countHuman;
	
	public ResponseAdnDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResponseAdnDTO(boolean mutant, int countMutant, int countHuman) {
		super();
		this.mutant = mutant;
		this.countMutant = countMutant;
		this.countHuman = countHuman;
	}

	public boolean isMutant() {
		return mutant;
	}

	public void setMutant(boolean mutant) {
		this.mutant = mutant;
	}

	public int getCountMutant() {
		return countMutant;
	}

	public void setCountMutant(int countMutant) {
		this.countMutant = countMutant;
	}

	public int getCountHuman() {
		return countHuman;
	}

	public void setCountHuman(int countHuman) {
		this.countHuman = countHuman;
	}

}
