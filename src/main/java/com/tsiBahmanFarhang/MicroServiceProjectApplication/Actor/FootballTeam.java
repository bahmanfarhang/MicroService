package com.tsiBahmanFarhang.MicroServiceProjectApplication.Actor;

public class FootballTeam {
    // let's consider this a football team for example
    private String name;
    private int nbOfPlayers;

    private String coach;
    private String stadium;

    public FootballTeam(String name, int nbOfPlayers,String coach,String stadium){
        this.name = name;
        this.nbOfPlayers = nbOfPlayers;
        this.coach = coach;
        this.stadium = stadium;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }
//let's keep it simple for now


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNbOfPlayers() {
        return nbOfPlayers;
    }

    public void setNbOfPlayers(int nbOfPlayers) {
        this.nbOfPlayers = nbOfPlayers;
    }
}
