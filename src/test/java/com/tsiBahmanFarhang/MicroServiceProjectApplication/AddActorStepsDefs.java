package com.tsiBahmanFarhang.MicroServiceProjectApplication;

import com.tsiBahmanFarhang.MicroServiceProjectApplication.Actor.Actor;
import com.tsiBahmanFarhang.MicroServiceProjectApplication.Actor.ActorRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddActorStepsDefs {

    ActorRepository actorRepository;

    //MicroServiceProjectApplication app = new MicroServiceProjectApplication();

    //dummy actor
    Actor testActor = new Actor();

    @Given("i have actor info")
    public void i_have_actor_info() {
        // Write code here that turns the phrase above into concrete actions
    }
    @When("i the users first name equals {string}")
    public void i_the_users_first_name_equals(String string) {
        //set first person to string
        testActor.setFirst_name(string);
    }
    @When("the last name equals {string}")
    public void the_last_name_equals(String string) {
        // Write code here that turns the phrase above into concrete actions
        //set last name as string
        testActor.setLast_name(string);
    }
    @Then("the system returns {string}")
    public void the_system_returns(String string) {
        // Write code here that turns the phrase above into concrete action
        //app.addActor(testActor.getFirst_name(), testActor.getLast_name());
    }

}
