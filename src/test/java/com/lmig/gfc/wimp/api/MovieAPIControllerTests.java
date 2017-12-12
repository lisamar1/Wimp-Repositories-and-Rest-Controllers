package com.lmig.gfc.wimp.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.lmig.gfc.wimp.models.Actor;
import com.lmig.gfc.wimp.models.Movie;
import com.lmig.gfc.wimp.repositories.ActorRepository;
import com.lmig.gfc.wimp.repositories.MovieRepository;

public class MovieAPIControllerTests {

	private MovieAPIController controller;
	private MovieRepository repo;

	@Before
	public void setUp() {
		repo = mock(MovieRepository.class);
		controller = new MovieAPIController(repo);
	}

	@Test
	public void getAll_which_returns_a_list_of_movies() {
		// Arrange
		ArrayList<Movie> movies = new ArrayList<Movie>();
		when(repo.findAll()).thenReturn(movies);

		// Act
		List<Movie> actual = controller.getAll();

		// Assert
		assertThat(actual).isSameAs(movies);
		verify(repo).findAll();

	}

	@Test
	public void getOne_returns_movie_for_a_valid_ID() {
		// Arrange
		Movie movie = new Movie();
		when(repo.findOne(0L)).thenReturn(movie);

		// Act
		Movie actual = controller.getOne(0L);

		// Assert
		assertThat(actual).isSameAs(movie);
		verify(repo).findOne(0L);
	}

	@Test
	public void create_saves_the_movie_and_returns_movie() {
		// Arrange
		Movie movie = new Movie();
		when(repo.save(movie)).thenReturn(movie);

		// Act
		Movie actual = controller.create(movie);

		// Assert
		assertThat(actual).isSameAs(movie);
		verify(repo).save(movie);

	}

	@Test
	public void update_sets_id_of_movie_and_calls_save_and_returns_movie() {
		// Arrange
		Movie movie = new Movie();
		when(repo.save(movie)).thenReturn(movie);

		// Act
		Movie actual = controller.update(movie, 0L);

		// Assert
		assertThat(actual).isSameAs(movie);
		verify(repo).save(movie);
		assertThat(movie.getId()).isEqualTo(0L);

	}

	@Test
	public void delete_gets_the_movie_and_deletes_it_from_the_rep_and_returns_it() {
		// Arrange
		Movie movie = new Movie();
		when(repo.findOne(5L)).thenReturn(movie);
		// Act
		Movie actual = controller.delete(5L);
		// Assert
		assertThat(actual).isSameAs(movie);
		verify(repo).findOne(5L);
		verify(repo).delete(5L);
	}
}