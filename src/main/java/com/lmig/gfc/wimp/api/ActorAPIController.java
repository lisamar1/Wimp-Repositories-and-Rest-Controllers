package com.lmig.gfc.wimp.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.lmig.gfc.wimp.models.Actor;
import com.lmig.gfc.wimp.repositories.ActorRepository;

@RestController
@RequestMapping("/api/actors")
public class ActorAPIController {

	private ActorRepository actorRepository;

	public ActorAPIController(ActorRepository actorRepository) {
		this.actorRepository = actorRepository;

	}

	@GetMapping("")
	public List<Actor> getAll() {
		return actorRepository.findAll();

	}

	@GetMapping("{id}")
		public Actor getOne(@PathVariable String id) {
			return actorRepository.findOne(id);
	}

	@PostMapping("")
		@ResponseStatus(code=HttpStatus.CREATED)
		public Actor create(@RequestBody Actor actor) {
			return actorRepository.save(actor);
	}

	@PutMapping("{id}")
	public Actor update(@RequestBody Actor actor, @PathVariable Long id) {
		actor.setId(id);
		return actorRepository.save(actor);

	}

	@DeleteMapping("{id}")
		public Actor delete(@PathVariable String id) {
			Actor actor = actorRepository.findOne(id);
			actorRepository.delete(id);
			return actor;

		}
}
