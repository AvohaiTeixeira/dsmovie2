package com.atos.dsmovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atos.dsmovie.entities.Score;
import com.atos.dsmovie.entities.ScorePk;

public interface ScoreRepository extends JpaRepository<Score, ScorePk> {

}
