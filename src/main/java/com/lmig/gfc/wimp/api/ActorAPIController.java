package com.lmig.gfc.wimp.api;

import java.util.ArrayList;
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

		List<Actor> actors = actorRepository.findAll();
		ArrayList<ActorView> actorViews = new ArrayList<ActorView>();
		for (Actor actor : actors) {
			actorViews.add(new ActorView(actor));
		}
		return actors;

	}

	@GetMapping("{id}")
	public ActorView getOne(@PathVariable Long id) { // 1 Change the return type to be ActorView-based
		Actor actor = actorRepository.findOne(id); // 2 Put the actor into a variable
		ActorView view = new ActorView(actor); // 3 Create an ActorView based on that actor
		return view; // 4 Return the new instance of ActorView
	}

	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ActorView create(@RequestBody Actor actor) {
		actorRepository.save(actor);
		ActorView view = new ActorView(actor); // 3 Create an ActorView based on that actor
		return view;
	}

	@PutMapping("{id}")
	public ActorView update(@RequestBody Actor actor, @PathVariable Long id) {
		actor.setId(id);
		actorRepository.save(actor);
		ActorView view = new ActorView(actor); // 3 Create an ActorView based on that actor
		return view;
	}

	@DeleteMapping("{id}")
	public ActorView delete(@PathVariable Long id) {
		Actor actor = actorRepository.findOne(id);
		actorRepository.delete(id);
		ActorView view = new ActorView(actor);
		return view;

	}
}
