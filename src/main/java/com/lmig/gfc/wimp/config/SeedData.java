package com.lmig.gfc.wimp.config;

import java.sql.Date;

import org.springframework.context.annotation.Configuration;

import com.lmig.gfc.wimp.models.Actor;
import com.lmig.gfc.wimp.models.Award;
import com.lmig.gfc.wimp.models.Movie;
import com.lmig.gfc.wimp.repositories.ActorRepository;
import com.lmig.gfc.wimp.repositories.AwardRepository;
import com.lmig.gfc.wimp.repositories.MovieRepository;

@Configuration
public class SeedData {

	public SeedData(ActorRepository actorRepository, MovieRepository movieRepository, AwardRepository awardRepository) {

		movieRepository.save(new Movie("Rosencrantz & Guildenstern Are Dead", new Date(2016 - 1900, 5 - 1, 1), 500000L,
				"Cinecom Pictures"));
		movieRepository.save(new Movie("Four Rooms", new Date(2017 - 1900, 8 - 1, 10), 4000000L, "Mirimax Films"));
		Actor tim = actorRepository.save(new Actor("Tim", "Roth", 1982L, new Date(2017 - 1900, 10 - 1, 5)));
		actorRepository.save(new Actor("Marissa", "Tomei", 1984L, new Date(2017 - 1900, 11 - 1, 5)));
		awardRepository.save(new Award("Best Actor in a Supporting Role", "BAFTA", 1995, tim));
		awardRepository.save(new Award("Best Actor", "Stockholm International Film Festival", 2012, tim));

	}

}