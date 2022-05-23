package com.citb408;

public class Projection {
    private String name;
    private int maxNumberOfTickets;
    private int soldTickets;

    public Projection(String name, int maxNumberOfTickets) {
        this.name = name;
        this.maxNumberOfTickets = maxNumberOfTickets;
        this.soldTickets = 0;
    }

    public int availableTickets(){
        return this.maxNumberOfTickets - this.soldTickets;
    }

    public synchronized boolean sellTickets(int tickets){
        if(this.availableTickets()>=tickets){
            this.soldTickets+=tickets;
            return true;
        }
        return false;
    }


}
