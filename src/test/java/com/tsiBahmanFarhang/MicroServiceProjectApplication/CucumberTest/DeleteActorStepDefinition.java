package com.tsiBahmanFarhang.MicroServiceProjectApplication.CucumberTest;

import com.tsiBahmanFarhang.MicroServiceProjectApplication.Actor.Actor;
import com.tsiBahmanFarhang.MicroServiceProjectApplication.Actor.ActorRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

public class DeleteActorStepDefinition {

    ActorRepository actorRepository;

    URI url;
    RestTemplate restTemplate;
    ResponseEntity<Actor[]> response;

    @Given("I want to delete an actor by entering the actor id")
    public void i_want_to_delete_an_actor_by_entering_the_actor_id() {
        try {
            //url = new URI ("http://localhost:8080/api/v1/actor/allActors");
            url = new URI ("https://mymicroservice-1655722916353.azurewebsites.net/api/v1/actor/allActors");
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
    @When("I request to delete an actor by the actor id")
    public void i_request_to_delete_an_actor_by_the_actor_id() {
        restTemplate = new RestTemplate();
        response = restTemplate.getForEntity(url, Actor[].class);
    }
    @Then("I should no longer see the deleted actor")
    public void i_should_no_longer_see_the_deleted_actor() {
        Assert.isTrue(response.getStatusCode() == HttpStatus.OK);
    }
}
