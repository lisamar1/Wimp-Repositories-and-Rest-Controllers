package com.lmig.gfc.wimp.api;

import java.sql.Date;
import java.util.List;

import com.lmig.gfc.wimp.models.Actor;
import com.lmig.gfc.wimp.models.Movie;

public class MovieView {

	private Movie movie;

	public MovieView(Movie movie) {
		this.movie = movie;
	}

	public Long getId() {
		return movie.getId();
	}

	public String getTitle() {
		return movie.getTitle();
	}

	public Date getReleaseDate() {
		return movie.getReleaseDate();
	}

	public Long getBudget() {
		return movie.getBudget();
	}

	public String getDistributor() {
		return movie.getDistributor();
	}

}
