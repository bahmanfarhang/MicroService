package com.tsiBahmanFarhang.MicroServiceProjectApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*") // needed for receiving request via api
@SpringBootApplication
@RestController // Handles GET, POST, DELETE, PUT requests
@RequestMapping("/home")//base url
public class MicroServiceProjectApplication {

	@Autowired
	public ActorRepository actorRepository;

	public String saved = "saved";
	public static void main(String[] args) {
		SpringApplication.run(MicroServiceProjectApplication.class, args);
	}
	public MicroServiceProjectApplication(ActorRepository actorRepository){
		this.actorRepository = actorRepository;
	}

	@GetMapping(value = "/All_Actors")
	public @ResponseBody
	Iterable<Actor>getAllActors(){
		return actorRepository.findAll();
	}

	//create operation
	@PostMapping(value = "/Add_Actor")
	public @ResponseBody String addActor(@RequestParam String first_name, String last_name){
		Actor addActor = new Actor(first_name, last_name);
		actorRepository.save(addActor);
		return "saved new actor " + first_name + " " + last_name;
	}
	@DeleteMapping(value = "/Delete_ById")
	public String deleteById(@RequestParam(value = "ID") int id) {
		actorRepository.deleteById(id);
		return "Deleted the actor with the ID " + id;

	}
	@PutMapping(value = "/Update_Actor")
	public @ResponseBody String updateActor(@RequestParam String update_first_name, String update_last_name){
		Actor updateActor = new Actor(update_first_name, update_last_name);
		//actorRepository.updateActor(updateActor);
		return "updated actor";
	}


}
