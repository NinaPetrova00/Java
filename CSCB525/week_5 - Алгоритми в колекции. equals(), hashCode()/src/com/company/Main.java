package com.company;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Collection Framework Algorithms
        {
            Movie trolls = new Movie(1,"Trolls", 80);
            Movie hotelTransylvania = new Movie(2,"Hotel Transylvania", 90);
            Movie theCars = new Movie(3,"The Cars I", 100);
            Movie zootopia = new Movie(4,"Zootopia", 90);
            Movie findingDory = new Movie(5,"Finding Dory", 105);
            Movie howToTrainYourDragon = new Movie(6,"How to Train Your Dragon", 90);
            Movie kungFuPanda = new Movie(7,"Kung Fu Panda", 87);

            Cinema arena = new Cinema("Arena");
            arena.addMovieToProgram(trolls);
            arena.addMovieToProgram(hotelTransylvania);
            arena.addMovieToProgram(theCars);
            arena.addMovieToProgram(zootopia);
            arena.addMovieToProgram(findingDory);
            arena.addMovieToProgram(howToTrainYourDragon);
            arena.addMovieToProgram(kungFuPanda);
            arena.addMovieToProgram(kungFuPanda);
            arena.addMovieToProgram(kungFuPanda);
            arena.addMovieToProgram(kungFuPanda);
            arena.displayProgram();

            arena.removeMovieFromProgram(kungFuPanda);
            arena.displayProgram();

            arena.swapFirstWithLastMovie();
            arena.displayProgram();

            arena.sortByName();
            arena.displayProgram();

            arena.shuffleMovies();
            arena.displayProgram();

            arena.rotateMovies(3);
            arena.displayProgram();

            arena.addMovieToProgram(trolls);
            arena.addMovieToProgram(trolls);
            System.out.println(arena.numberOfMovieProjections(trolls));

            arena.removeMovieFromProgram(theCars);
            arena.removeMovieFromProgram(zootopia);
            arena.removeMovieFromProgram(howToTrainYourDragon);
            arena.removeMovieFromProgram(kungFuPanda);
            arena.displayProgram();

            Cinema cinemaCity = new Cinema("Cinema City");
            cinemaCity.addMovieToProgram(theCars);
            cinemaCity.addMovieToProgram(zootopia);
            cinemaCity.addMovieToProgram(theCars);
            cinemaCity.addMovieToProgram(howToTrainYourDragon);
            cinemaCity.addMovieToProgram(kungFuPanda);
            cinemaCity.displayProgram();

            System.out.println(arena.disjointPrograms(cinemaCity));

            System.out.println(new Movie(8,"The Cars", 90)
                    .equals(new Movie(8,"The Cars", 90)));

            // Shallow and Deep Copy
             List<Movie> copyCinemaCityProgram = cinemaCity.getProgram();
            // List<Movie> copyCinemaCityProgram = cinemaCity.getProgram2();
            // List<Movie> copyCinemaCityProgram = cinemaCity.getProgram3();
            System.out.println("Copy of the Program of Cinema City: ");
            copyCinemaCityProgram.forEach(movie -> System.out.println(movie));
            copyCinemaCityProgram.add(trolls);

            System.out.println("After adding Trolls to the Copy: ");
            cinemaCity.displayProgram();
            copyCinemaCityProgram.get(0).setName("Copy");
            cinemaCity.displayProgram();


        }
    }
}
