package com.company;

/**
 * @author Kostadinova
 */
public class Movie implements Comparable<Movie> {

    private long id;
    private String name;
    private double duration;

    public Movie() {
    }

    public Movie(long id, String name, double duration) {
        this.id = id;
        this.name = name;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public double getDuration() {
        return duration;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Movie{" + "name=" + name + ", duration=" + duration + '}';
    }

    // Copy Constructor
    public Movie(Movie copy) {
        this(copy.getId(), copy.getName(), copy.getDuration());
        System.out.println("In COPY CONSTRUCTOR");
    }


    @Override
    public int compareTo(Movie movie) {
        return this.name.compareTo(movie.name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public void setId(long id) {
        this.id = id;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Movie movie = (Movie) o;
//
//        if (id != movie.id) return false;
//        if (Double.compare(movie.duration, duration) != 0) return false;
//        return name.equals(movie.name);
//    }
//
//    @Override
//    public int hashCode() {
//        int result;
//        long temp;
//        result = (int) (id ^ (id >>> 32));
//        result = 31 * result + name.hashCode();
//        temp = Double.doubleToLongBits(duration);
//        result = 31 * result + (int) (temp ^ (temp >>> 32));
//        return result;
//    }
}
