package com.tsiBahmanFarhang.MicroServiceProjectApplication;

import com.tsiBahmanFarhang.MicroServiceProjectApplication.Actor.Actor;
import com.tsiBahmanFarhang.MicroServiceProjectApplication.Actor.ActorRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddActorStepsDefs {

    ActorRepository actorRepository;
    // bro ngl , this looks fun more than coding hahah cmon its saem thing>? idk but i'm curious rn lool im confused
    //tbh it looks easy , well u give a user story then it translates and u make a test out of it using "dummy data "
    //,niice looks fun tbh yes, only issure it im not too sure how to do it, yeah you should master java first tbh yhhhhh yjis is so true bro
    // tbh personally ,i've understood everything in that code , it's just i need to know how that framework works yh, i need to set it up to use it and ot test bro
    //let's do a challenge , learn mockito in this 15/30 min and implement it , are you down - ok this new framework is cucumber
    //lets fix that mockito shit first hahahha lol, its harder than i thought el ow el

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
        // Write code here that turns the phrase above into concrete actions
        //app.addActor(testActor.getFirst_name(), testActor.getLast_name());
    }

}
