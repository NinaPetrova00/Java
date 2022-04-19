package com.citb408;

import com.citb408.shops.FlowersShop;
import com.citb408.video.Author;
import com.citb408.video.Video;

import java.math.BigDecimal;

public class Main {

    public static boolean isMoreProfitable(FlowersShop flowersShop,FlowersShop flowersShop){

    }
    public static void main(String[] args) {
        // Box box1 = new Box(BigDecimal.valueOf(10),BigDecimal.valueOf(20), BigDecimal.valueOf(30));
        // System.out.println(box1);

        Author author = new Author("Maria",27);
        Video.setMaxDuration(BigDecimal.valueOf(5));

        Video video1 = new Video(1,"My Video 1", BigDecimal.valueOf(3.4),author);
        Video video2 = new Video(2,"My Video 2", BigDecimal.valueOf(3.4),author);

        Video.setMaxDuration(BigDecimal.valueOf(10));

        System.out.println(video1);
        System.out.println(video2);
        //video.setName("New name");
        //System.out.println(video.toString());
        //System.out.println(video); същото е като горния ред = System.out.println(video.toString());

        FlowersShop flowersShop1 = new FlowersShop(120,BigDecimal.valueOf(5));
        FlowersShop flowersShop2 = new FlowersShop(100,BigDecimal.valueOf(5));

        flowersShop1.isFirstShopMoreProfitable(flowersShop2);
        Main.isMoreProfitable(flowersShop1,flowersShop2);
    }
}
