package com.citb408;

public class TicketsSelling implements Runnable{
    private Projection projection;
    private int tickets;

    public TicketsSelling(Projection projection, int tickets) {
        this.projection = projection;
        this.tickets = tickets;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" "+this.tickets);
        System.out.println(projection.sellTickets(this.tickets));
    }
}
