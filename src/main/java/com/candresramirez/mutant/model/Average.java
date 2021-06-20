package com.candresramirez.mutant.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Average {
	
    @Id
    @GeneratedValue
    private int id;
    private int countAdnMutant;
    private int countAdnHuman;
    private BigDecimal ratio;
    
	public Average() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCountAdnMutant() {
		return countAdnMutant;
	}

	public void setCountAdnMutant(int countAdnMutant) {
		this.countAdnMutant = countAdnMutant;
	}

	public int getCountAdnHuman() {
		return countAdnHuman;
	}

	public void setCountAdnHuman(int countAdnHuman) {
		this.countAdnHuman = countAdnHuman;
	}

	public BigDecimal getRatio() {
		return ratio;
	}

	public void setRatio(BigDecimal ratio) {
		this.ratio = ratio;
	}
}
