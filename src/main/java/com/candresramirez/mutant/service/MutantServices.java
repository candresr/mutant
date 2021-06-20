package com.candresramirez.mutant.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.candresramirez.mutant.dto.RequestMutantDTO;
import com.candresramirez.mutant.dto.ResponseAdnDTO;
import com.candresramirez.mutant.dto.ResponseAverageDTO;
import com.candresramirez.mutant.dto.ResponseGenericDTO;
import com.candresramirez.mutant.model.Average;
import com.candresramirez.mutant.repository.AverageRepository;
import com.candresramirez.mutant.util.MutantUtil;

@Service
public class MutantServices {
	
	@Autowired
	AverageRepository averageRepository; 

	public ResponseGenericDTO findMutant(RequestMutantDTO dto) {

		String[] adn = dto.getAdn();
		MutantUtil util = new MutantUtil();
		String[][] matriz = util.convertToArray(adn);

		ResponseAdnDTO h = horizontal(matriz);
		ResponseAdnDTO v = vertical(matriz);
		ResponseAdnDTO d = diagonal(matriz);
		
		if(h.isMutant() || v.isMutant() || d.isMutant()) {
			saveAverage(h, v, d);
			return new ResponseGenericDTO(true, "OK", HttpStatus.OK);
		}else {
			return new ResponseGenericDTO(false, "FAIL", HttpStatus.FORBIDDEN);
		}

	}

	public ResponseAdnDTO diagonal(String[][] matriz) {
		boolean diagonal = false;
		int countM = 0, countH =0;

		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				if (matriz[i][j].equals(matriz[i + 1][ j + 1]) &&
						matriz[i][j].equals(matriz[i + 2][ j + 2]) &&
						matriz[i][j].equals(matriz[i + 3][ j + 3]))
				{
					diagonal = true;
					countM += verificarAdn(matriz, i, j);
				}else {
					countH++;
				}
			}
		}
		return new ResponseAdnDTO(diagonal, countM, countH);
	}

	public ResponseAdnDTO horizontal(String[][] matriz) {

		boolean horizontal = false;
		int countM = 0, countH =0;

		for (int i = 0; i < matriz.length; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				if (matriz[i][j].equals(matriz[i][ j + 1]) &&
						matriz[i][j].equals(matriz[i][ j + 2]) &&
						matriz[i][j].equals(matriz[i][ j + 3]))
				{
					horizontal = true;
					countM += verificarAdn(matriz, i, j);
				}else {
					countH++;
				}
			}
		}
		return new ResponseAdnDTO(horizontal, countM, countH);
	}

	public ResponseAdnDTO vertical(String[][] matriz) {

		boolean vertical = false;
		int countM = 0, countH =0;

		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < matriz.length; j++)
			{
				if (matriz[i][j].equals(matriz[i + 1][j]) &&
						matriz[i][j].equals(matriz[i + 2][j]) &&
						matriz[i][j].equals(matriz[i + 3][j]))
				{
					vertical = true;
					countM += verificarAdn(matriz, i, j);
				}else {
					countH++;
				}
			}
		}
		return new ResponseAdnDTO(vertical, countM, countH);
	}

	public int verificarAdn(String[][] matriz, int i, int j) {
		int contA = 0;
		int contC = 0;
		int contG = 0;
		int contT = 0;

		if (matriz[i][j].equals("A"))
		{
			contA++;
		}
		else if (matriz[i][j].equals("C"))
		{
			contC++;
		}
		else if (matriz[i][j].equals("G"))
		{
			contG++;
		}
		else if (matriz[i][j].equals("T"))
		{
			contT++;
		}

		int total = (contA+contC+contG+contT);

		return total;
	}
	
	public void saveAverage(ResponseAdnDTO h, ResponseAdnDTO v, ResponseAdnDTO d) {
		int countMutantAdn = h.getCountMutant() + v.getCountMutant() + d.getCountMutant();
		int countHumanAdn = h.getCountHuman() + v.getCountHuman() + d.getCountHuman();
		
		BigDecimal totalM = new BigDecimal(countMutantAdn);
		BigDecimal totalH = new BigDecimal(countHumanAdn);
		BigDecimal sum = totalM.add(totalH);
		
		BigDecimal ratio = totalM.divide(sum, 4, RoundingMode.HALF_UP);
		
		Average ave = new Average();
		ave.setCountAdnMutant(countMutantAdn);
		ave.setCountAdnHuman(countHumanAdn);
		ave.setRatio(ratio);
		averageRepository.save(ave);
	}
	
	public ResponseAverageDTO stats() {
        List<Average> ave = new ArrayList<Average>();
        averageRepository.findAll().forEach(data -> ave.add(data));
        return new ResponseAverageDTO(ave, true, HttpStatus.OK);
	}
}
