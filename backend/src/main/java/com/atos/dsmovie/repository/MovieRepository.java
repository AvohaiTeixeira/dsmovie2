package com.atos.dsmovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atos.dsmovie.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
