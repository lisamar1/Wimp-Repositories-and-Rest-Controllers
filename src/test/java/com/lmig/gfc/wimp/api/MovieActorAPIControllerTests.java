package com.lmig.gfc.wimp.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.lmig.gfc.wimp.models.Actor;
import com.lmig.gfc.wimp.models.Movie;
import com.lmig.gfc.wimp.repositories.ActorRepository;
import com.lmig.gfc.wimp.repositories.MovieRepository;

public class MovieActorAPIControllerTests {
	
	private MovieActorAPIController controller;
	@Mock
	private MovieRepository movieRepo;
	@Mock
	private ActorRepository actorRepo;

	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		controller = new MovieActorAPIController(actorRepo, movieRepo);

}
	@Test
	public void creates_get_the_movie_adds_movie_saves_actor() {
		//Arrange
		Movie movie = new Movie();
		movie.setActors(new ArrayList<Actor>());
		Actor actor = new Actor();
		when(movieRepo.findOne(2L)).thenReturn(movie);
		when(actorRepo.findOne(3L)).thenReturn(actor);

		// Act
		Movie actual = controller.create(2L, 3L);
		
		// Asset
		assertThat(actual).isSameAs(movie);
		verify(movieRepo).save(movie);
		assertThat(movie.getActors()).contains(actor);
		verify(movieRepo).findOne(2L);
		verify(actorRepo).findOne(3L);
			
		
	}
	
	
}
