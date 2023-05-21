package com.cscb525;

import java.util.Map;
import java.util.TreeMap;

public class Olympiad {
    private int date;
    private String place;

    /*За всеки от видовете спорт, има определен
    максимален брой на участниците, които могат да участват в олимпиадата.*/
    private Map<Sport, Integer> sportPlayers;
    private Map<Team, Integer> teamsMap;
    private static int numberOfTeams = 0;

    public Olympiad(int date, String place) {
        this.date = date;
        this.place = place;
        sportPlayers = new TreeMap<>();
        teamsMap = new TreeMap<>();
    }

    public int getDate() {
        return date;
    }

    public String getPlace() {
        return place;
    }

    /*a) Възможност за добавяне на отбори, които ще участват на олимпиадата*/
    public void addTeam(Team team){
        teamsMap.put(team,++numberOfTeams);
    }

    /*c) Възможност за премахване на отбор*/
    public void removeTeam(Team team){
        teamsMap.remove(team);
    }

    /*d) Възможност за премахване на спортист от отбор. Ако от отбора, който участва на
олимпиадата се премахне титуляр, трябва първата резерва да стане титуляр (играчите
са подредени по азбучен ред)*/
    public void removeAthlete(Athlete athlete){

    }

}
