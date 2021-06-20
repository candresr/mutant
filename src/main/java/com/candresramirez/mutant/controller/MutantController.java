package com.candresramirez.mutant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.candresramirez.mutant.dto.RequestMutantDTO;
import com.candresramirez.mutant.dto.ResponseAverageDTO;
import com.candresramirez.mutant.dto.ResponseGenericDTO;
import com.candresramirez.mutant.service.MutantServices;

@RestController
@RequestMapping("/api")
public class MutantController {
	
	@Autowired
	private MutantServices mutantService;

	@PostMapping("/mutant")
	public ResponseGenericDTO findMutant(@RequestBody RequestMutantDTO adn) {
		return mutantService.findMutant(adn);
	}
	
	@GetMapping("/stats")
	public ResponseAverageDTO stats() {
		return mutantService.stats();
	}
}
