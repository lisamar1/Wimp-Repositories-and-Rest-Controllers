package com.lmig.gfc.wimp.api;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import com.lmig.gfc.wimp.models.Actor;
import com.lmig.gfc.wimp.repositories.ActorRepository;
import org.junit.Before;
import org.junit.Test;

public class ActorAPIControllerTests {

	private ActorAPIController controller;
	private ActorRepository repo;
	
	@Before
	public void setUp() {
		repo = mock(ActorRepository.class);
		controller = new ActorAPIController(repo);

	}

	@Test
	public void getAll_returns_a_list_of_actors() {
		// Arrange
		ArrayList<Actor> actors = new ArrayList<Actor>();
		when(repo.findAll()).thenReturn(actors);

		// Act
		List<Actor> actual = controller.getAll();

		// Assert
		assertThat(actual).isSameAs(actors);
		verify(repo).findAll();

	}

	@Test
	public void getOne_returns_actor_for_a_valid_ID() {
		// Arrange
		Actor actor = new Actor();
		when(repo.findOne(2L)).thenReturn(actor);
		
		// Act
		ActorView actual = controller.getOne(2L);

		// Assert

		assertThat(actual).isNotNull();
		verify(repo).findOne(2L);

	}

	@Test
	public void create_saves_the_actor_and_returns_actorview() {
		// Arrange
		Actor actor = new Actor();
		when(repo.save(actor)).thenReturn(actor);

		// Act
		ActorView actual = controller.create(actor);

		// Assert
		assertThat(actual).isNotNull();
		verify(repo).save(actor);

	}

	@Test
	public void update_sets_id_of_actor_and_calls_save_and_returns_actor() {
		// Arrange
		Actor actor = new Actor();
		when(repo.save(actor)).thenReturn(actor);

		// Act
		ActorView actual = controller.update(actor, 40L);

		// Assert
		assertThat(actual).isNotNull();
		verify(repo).save(actor);
		assertThat(actor.getId()).isEqualTo(40L);

	}

	@Test
	public void delete_gets_the_actor_and_deletes_it_from_the_rep_and_returns_it() {
		// Arrange
		Actor actor = new Actor();
		when(repo.findOne(10L)).thenReturn(actor);

		// Act
		ActorView actual = controller.delete(10L);

		// Assert
		assertThat(actual).isNotNull();
		verify(repo).findOne(10L);
		verify(repo).delete(10L);
	}

}