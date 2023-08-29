package com.atos.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atos.dsmovie.dto.MovieDto;
import com.atos.dsmovie.dto.ScoreDto;
import com.atos.dsmovie.entities.Movie;
import com.atos.dsmovie.entities.Score;
import com.atos.dsmovie.entities.User;
import com.atos.dsmovie.repository.MovieRepository;
import com.atos.dsmovie.repository.ScoreRepository;
import com.atos.dsmovie.repository.UserRepository;

@Service
public class ScoreService {

	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ScoreRepository scoreRepository;
	
	@Transactional
	public MovieDto saveScore(ScoreDto dto) {
		
		//Busca o Usuário do banco
		User user = userRepository.findByEmail(dto.getEmail());
		
		System.out.println("TESTE ATOS " + dto.getEmail().toString());
		
		//Se o Usuário não existir na base, cadastra como novo Usuário.
		if (user == null) {
			System.out.println("Criando Usuário com o e-mail " + dto.getEmail().toString());
			user = new User();
			user.setEmail(dto.getEmail());
			
			user = userRepository.saveAndFlush(user);
		} 
		
		System.out.println(user.getEmail().toString());
		System.out.println("TESTE");
		
		//Busca o filme
		Movie movie = movieRepository.findById(dto.getMovieId()).get();
		
		//Busca o score
		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(dto.getScore());
		
		//Salva o score
		score = scoreRepository.saveAndFlush(score);
		
		//Busca todos os scores para calcular a média
		Double somaScore = 0.00;
		for (Score s : movie.getScores()) {
			
			somaScore = somaScore + s.getValue();
		}
		
		//Calcula a média de scores do filme.
		Double mediaScore = somaScore / movie.getScores().size();
		
		
		//Insere a média de score e a quantidade de scores no filme
		movie.setScore(mediaScore);
		movie.setCount(movie.getScores().size());
		
		//Salva o filme
		movie = movieRepository.save(movie);
		
		return new MovieDto(movie);	
	}
}
