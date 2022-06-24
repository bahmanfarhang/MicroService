package com.tsiBahmanFarhang.MicroServiceProjectApplication.CucumberTest;

import com.tsiBahmanFarhang.MicroServiceProjectApplication.Actor.Actor;
import com.tsiBahmanFarhang.MicroServiceProjectApplication.Actor.ActorRepository;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;


public class AddActorStepDefinition {

    ActorRepository actorRepository;

    URI url;
    RestTemplate restTemplate;
    ResponseEntity<Actor[]> response;

    @Given("I want to add an actor by entering actor first name")
    public void i_want_to_add_an_actor_by_entering_actor_first_name() {
        try {
            //url = new URI ("http://localhost:8080/api/v1/actor/allActors");
            url = new URI("https://mymicroservice-1655722916353.azurewebsites.net/api/v1/actor/allActors");
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
    @And("by entering actor last name")
    public void by_entering_actor_last_name() {

    }
    @When("I request to add the actor by the actor first and last name")
    public void i_request_to_add_the_actor_by_the_actor_first_and_last_name() {
        restTemplate = new RestTemplate();
        response = restTemplate.getForEntity(url, Actor[].class);
    }
    @Then("I should now see the added actor")
    public void i_should_now_see_the_added_actor() {
        Assert.isTrue(response.getStatusCode() == HttpStatus.OK);
    }
}
