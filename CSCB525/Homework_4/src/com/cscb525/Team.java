package com.cscb525;

import java.util.Map;
import java.util.TreeMap;

public class Team {
    private String name;
    private int budget;

    /*За всеки вид спорт броят на играчите в отбора е различен*/
    private  Map<Sport, Integer> countOfPlayers;
    /*Всеки спортист се съхранява трансферната сума*/
    private  Map<Athlete, Double> athleteTransferSum;
    /*Треньорът и вид спорт, за който е квалифициран да изпълнява дейност.*/
    private Map<Coach, Sport> coachSportMap;
    /*Всеки спортист има име и вид спорт, който практикува*/
    private Map<Athlete, Sport> athleteSportMap;

    public Team(String name, int budget) {
        this.name = name;
        this.budget = budget;
        countOfPlayers = new TreeMap<>();
        athleteTransferSum =  new TreeMap<>();
        countOfPlayers = new TreeMap<>();
        athleteSportMap = new TreeMap<>();
    }

    public String getName() {
        return name;
    }

    public int getBudget() {
        return budget;
    }

    /*b) Възможност за определяне на списъка със спортисти от всеки отбор, които ще участват
    е олимпиадата.
    За всеки спортист трябва да се обозначи дали е в титулярния състав или
    е резерва.
    Броят на титулярите не трябва да надхвърля, определения брой играчи за
    всеки вид спорт. Общият брой участници не трябва да надхвър*/


}
