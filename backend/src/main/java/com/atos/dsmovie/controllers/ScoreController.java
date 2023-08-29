package com.atos.dsmovie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atos.dsmovie.dto.MovieDto;
import com.atos.dsmovie.dto.ScoreDto;
import com.atos.dsmovie.services.ScoreService;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/scores")
public class ScoreController {
	
	@Autowired
	private ScoreService service;
	
	@PutMapping
	public MovieDto saveScore(@RequestBody ScoreDto dto) {
		MovieDto movieDto = service.saveScore(dto);
		return movieDto;
	}
}
