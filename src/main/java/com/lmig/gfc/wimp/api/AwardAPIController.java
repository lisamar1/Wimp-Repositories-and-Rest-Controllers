package com.lmig.gfc.wimp.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lmig.gfc.wimp.models.Actor;
import com.lmig.gfc.wimp.models.Award;
import com.lmig.gfc.wimp.repositories.ActorRepository;
import com.lmig.gfc.wimp.repositories.AwardRepository;

@RestController
@RequestMapping("/api/actors/{actorId}/awards")
public class AwardAPIController {

	private AwardRepository awardRepository;
	private ActorRepository actorRepository;

	public AwardAPIController(AwardRepository awardRepository, ActorRepository actorRepository) {
		this.awardRepository = awardRepository;
		this.actorRepository = actorRepository;
	}

	@PostMapping("")
	public Award create(@PathVariable Long actorId, @RequestBody Award award) {
		Actor actor = actorRepository.findOne(actorId);
		award.setActor(actor);
		awardRepository.save(award);
		return award;

		// Get the actor from the actor repository using the actorId, i.e., from the
		// database
		// set the actor on the award
		// save the award
		// return the award

	}
}