package com.citb408;

public class Main {

    public static void main(String[] args) {

        // Task 1
        {
            System.out.println(Thread.currentThread());

            Scan scan1 = new Scan("Doc 1", 10);
            Scan scan2 = new Scan("Doc 2", 15);

            Thread thread1 = new Thread(scan1, "Scan 1");
            Thread thread2 = new Thread(scan2, "Scan 2");
            thread1.start();
            thread2.start();
            System.out.println(thread1.isAlive());
            System.out.println(thread2.isAlive());
        }

        // Task 2
        {
            Projection projection = new Projection("Movie 1", 100);

            Thread thread1 = new Thread(new TicketsSelling(projection, 60), "Anna");
            Thread thread2 = new Thread(new TicketsSelling(projection, 90), "Ivan");

            thread1.start();
            thread2.start();

            try {
                thread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (!thread2.isAlive()) {
                System.out.println(projection.availableTickets());
            }
        }

        // Task 3
        {
            CarRace carRace = new CarRace(5);
            carRace.addRacer("Angel");
            carRace.addRacer("Peter");
            carRace.addRacer("Ivan");

            carRace.startRace();
        }
    }
}
