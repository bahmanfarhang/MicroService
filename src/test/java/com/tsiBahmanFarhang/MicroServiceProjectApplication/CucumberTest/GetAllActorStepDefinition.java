package com.tsiBahmanFarhang.MicroServiceProjectApplication.CucumberTest;
/* --- Acceptance Testing ---
* cucumber is a testing tool that supports BDD framework. it defines the application behaviour using simple english
*
* */
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

public class GetAllActorStepDefinition {

    ActorRepository actorRepository;

    URI url;
    //normal template to use in the code below
    RestTemplate restTemplate;
    //this is the response coming from the url
    ResponseEntity<Actor[]> response;
    //dummy actor
    @Given("the all actors end point")
    public void the_all_actors_end_point() {
        try {
            //url = new URI ("http://localhost:8080/api/v1/actor/allActors");
            url = new URI ("https://mymicroservice-1655722916353.azurewebsites.net/api/v1/actor/allActors");
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
    @When("the client calls all actors end point")
    public void the_client_calls_all_actors_end_point() {
        restTemplate = new RestTemplate();
        response = restTemplate.getForEntity(url, Actor[].class);
    }
    @Then("the client gets valid response")
    public void the_client_gets_valid_response() {
        Assert.isTrue(response.getStatusCode() == HttpStatus.OK);
    }
}
