package com.citb408;

public class MovieTheatre extends TradeCenter{
    private double ticketPrice;
    private int numberOfTicketsSold;

    public MovieTheatre(String name, String address, double ticketPrice, int numberOfTicketsSold) {
        super(name, address);
        this.ticketPrice = ticketPrice;
        this.numberOfTicketsSold = numberOfTicketsSold;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public int getNumberOfTicketsSold() {
        return numberOfTicketsSold;
    }

    @Override
    public String toString() {
        return "MovieTheatre{" +
                "ticketPrice=" + ticketPrice +
                ", numberOfTicketsSold=" + numberOfTicketsSold +
                "} " + super.toString();
    }
}
