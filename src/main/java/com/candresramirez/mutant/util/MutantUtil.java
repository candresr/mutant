package com.candresramirez.mutant.util;

public class MutantUtil {

	public String[][] convertToArray(String[] s) {
	    String[][] m = new String[s.length][s[0].length()];
	   
	    for (int i = 0; i < s.length; i++) {
			
			for (int j = 0; j < s[i].length(); j++) {				 
				m[i][j] = String.valueOf(s[i].charAt(j));	
				
			}
			
		}
	    
	    return m;
	}
}
