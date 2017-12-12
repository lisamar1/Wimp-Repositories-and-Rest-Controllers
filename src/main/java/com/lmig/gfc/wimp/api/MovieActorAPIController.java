package com.lmig.gfc.wimp.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lmig.gfc.wimp.models.Actor;
import com.lmig.gfc.wimp.models.Movie;
import com.lmig.gfc.wimp.repositories.ActorRepository;
import com.lmig.gfc.wimp.repositories.MovieRepository;

//Reference OwnersAPIController
@RestController
@RequestMapping("/api/movies/{movieId}/actors")

public class MovieActorAPIController {

	private ActorRepository ar;
	private MovieRepository mr;

	public MovieActorAPIController(ActorRepository ar, MovieRepository mr) {
		this.ar = ar;
		this.mr = mr;

	}

	@PostMapping("")
	public Movie create(@PathVariable Long movieId, @RequestBody Long actorId) {
		Actor actor = ar.findOne(actorId);
		Movie movie = mr.findOne(movieId);
		movie.getActors().add(actor);
		mr.save(movie);
		return movie;
	}

}
