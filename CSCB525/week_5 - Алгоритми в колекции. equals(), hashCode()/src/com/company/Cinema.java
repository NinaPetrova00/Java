package com.company;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Kostadinova
 */
public class Cinema {

    private String name;
    private List<Movie> program;

    public Cinema() {
        this.name = "No Name";
        this.program = new ArrayList();
    }

    public Cinema(String name) {
        this.name = name;
        this.program = new ArrayList();
    }

    public void addMovieToProgram(Movie movie) {
        program.add(movie);
    }

    //Task 1.1 Week 6
    public void removeMovieFromProgram(Movie movie) {
        List list = new ArrayList();
        list.add(movie);
        program.removeAll(list);
    }

    //Task 1.2 Week 6
    public void swapFirstWithLastMovie() {
        Collections.swap(program, 0, program.size() - 1);
    }

    //Task 1.3 Week 6
    public void sortByName() {
        Collections.sort(program);
    }

    //Task 1.4 Week 6
    public void shuffleMovies() {
        Collections.shuffle(program);
    }

    //Task 1.5 Week 6
    public void rotateMovies(int positions) {
        Collections.rotate(program, positions);
    }

    //Task 1.6 Week 6
    public int numberOfMovieProjections(Movie movie) {
        return Collections.frequency(program, movie);
    }

    //Task 1.7 Week 6
    public boolean disjointPrograms(Cinema cinema) {
        return Collections.disjoint(this.program, cinema.program);
    }

    public void displayProgram() {
        System.out.println("--------------- Cinema " + name + " program ------------");
        program.forEach(movie -> System.out.println(movie));
    }

    // Shallow and Deep Copy
    // Return the program
    public List<Movie> getProgram() {
        return program;
    }

    // Shallow and Deep Copy
    // Return the program
    public List<Movie> getProgram2() {
        return new ArrayList(program);
    }

    // Shallow and Deep Copy
    // Return the program
    public List<Movie> getProgram3() {
        List<Movie> copyProgram = new ArrayList(program.size());
        Iterator<Movie> iterator = program.iterator();
        while (iterator.hasNext()) {
            copyProgram.add(new Movie(iterator.next()));
        }
        return copyProgram;
    }


}
