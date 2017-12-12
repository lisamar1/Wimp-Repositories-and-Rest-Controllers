package com.lmig.gfc.wimp.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withCreatedEntity;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.lmig.gfc.wimp.models.Actor;
import com.lmig.gfc.wimp.models.Award;
import com.lmig.gfc.wimp.repositories.ActorRepository;
import com.lmig.gfc.wimp.repositories.AwardRepository;

public class AwardAPIControllerTests {

	private AwardAPIController controller;

	@Mock
	private AwardRepository awardRepo;
	@Mock
	private ActorRepository actorRepo;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		controller = new AwardAPIController(awardRepo, actorRepo);

	}

	@Test
	public void creates_an_actor_sets_it_on_the_award_and_saves_the_award() {
		// Arrange
		Award award = new Award();
		Actor actor = new Actor();
		when(actorRepo.findOne(3L)).thenReturn(actor);

		// Act
		Award actual = controller.create(3L, award);

		// Asset

		verify(actorRepo).findOne(3L);
		assertThat(actual).isSameAs(award);

	}

}
