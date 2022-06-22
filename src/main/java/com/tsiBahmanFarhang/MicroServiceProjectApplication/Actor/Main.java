package com.tsiBahmanFarhang.MicroServiceProjectApplication.Actor;

public class Main {

    public static void main(String[] args) {
        //We are creating the first team
        FootballTeam manchesterUtd = new FootballTeam("Manchester United",20,"bob","old trafford");

        //Let's create another team

        FootballTeam chelsea = new FootballTeam("chelsea",22,"Kante","Stamford bridge");//this?
        //exactly because when we first create an object , we call its constructor , therefore if we manage to fix variables
        // and associate them in constructor , we basically have done everything , and you can even create more constructors like
        // empty one , or one that doesn't accept coach or nb of players etc.... i see but we cant do
        chelsea.setName("Chelsea"); chelsea.setNbOfPlayers(22);chelsea.setCoach("kante");chelsea.setStadium("Stamford bridge");
        // yeah you got it now? yes, so

        //all that code went inside only 1 line which is

        //did you notice something? - i get that its basically the blue print and we can use its getters and setters to
        //create instances or objects ? rifgt? yeah but do you have a smart idea that can help us avoid typing 3 lines with
        // just only 2 variables , imagine we had like 5 variables or 10 ! for exmaple? for example lets add another variables
        // with only 2 objects here , we got like 20 lines , i magine having like 1k objects to create every single team in UK!
        //so constrcutor will help us to minimize code? boom you got it , now time show
    }
}
