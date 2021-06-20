package com.candresramirez.mutant.dto;

import java.util.Arrays;

public class RequestMutantDTO {

	private String[] adn;

	public RequestMutantDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RequestMutantDTO(String[] adn) {
		super();
		this.adn = adn;
	}

	public String[] getAdn() {
		return adn;
	}

	public void setAdn(String[] adn) {
		this.adn = adn;
	}

	@Override
	public String toString() {
		return "RequestMutantDTO [adn=" + Arrays.toString(adn) + "]";
	}
	
}
