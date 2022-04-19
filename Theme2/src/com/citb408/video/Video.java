package com.citb408.video;

import java.math.BigDecimal;
import java.time.LocalDate;

// POJO - Plain Old Java Object
public class Video {

    private final long id; // трябва да сме сигурни че задаваме стойността и в двата конструктора
    private String name;
    private BigDecimal duration;
    private static BigDecimal maxDuration;
    private Author author;
    private LocalDate uploadDate = LocalDate.of(2022, 3, 7);


    /*Constructor
    public Video() {
        this.id = 1;
    }*/

    //Constructor


    public Video(long id, String name, BigDecimal duration, Author author, LocalDate uploadDate) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.author = author;
        this.uploadDate = uploadDate;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getDuration() {
        return duration;
    }

    public void setDuration(BigDecimal duration) {
        Video.getMaxDuration().compareTo(duration);
        this.duration = duration;
    }

    public static BigDecimal getMaxDuration() {
        return maxDuration;
    }

    public static void setMaxDuration(BigDecimal maxDuration) {
        Video.maxDuration = maxDuration;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duration=" + duration +
                ", author=" + author +
                ", uploadDate=" + uploadDate +
                '}';
    }
}
