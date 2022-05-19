package com.citb408;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    // Task 1
    public static double readGoodPrice() {
        System.out.println("Enter the price of the goods: ");
        double price = 0;

        try {
            Scanner scanner = new Scanner(System.in);
            while ((price = scanner.nextDouble()) <= 0) {
                System.out.println("Enter positive number!");
            }
        } catch (InputMismatchException e) {
            e.printStackTrace();
        }

        return price;
    }

    // Task 2.1
    public static void writeGoods(String outputFileName, Goods goods) {

        try (FileWriter fout = new FileWriter(new File(outputFileName), true)) {
            if (goods != null) {
                fout.append(goods.toString() + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Task 2.2
    public static List<String> readGoodsFromFile(String inputFileName) {
        List<String> listOfGoods = new ArrayList<>();

        try (FileReader fis = new FileReader(inputFileName)) {
            BufferedReader bufferedReader = new BufferedReader(fis);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                listOfGoods.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listOfGoods;
    }

    // Task 3
    public static void serializeMovieTheatre(String file, MovieTheatre movieTheatre) {
        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream outputStream = new ObjectOutputStream(fos)) {
            outputStream.writeObject(movieTheatre);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Task 3
    public static MovieTheatre deserializeMovieTheatre(String fileName) {
        MovieTheatre movieTheatre = null;

        try (FileInputStream fis = new FileInputStream(fileName);
             ObjectInputStream inputStream = new ObjectInputStream(fis)) {
            movieTheatre = (MovieTheatre) inputStream.readObject();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return movieTheatre;
    }

    public static void main(String[] args) {

        // Task 1
        {
      /*  double goodsPrice = readGoodPrice();
        System.out.println(goodsPrice);*/
        }

        // Task 2
        {
            // Task 2.1
            Goods goods1 = new Goods("Meat", 13);
            Goods goods2 = new Goods("Butter", 5);
            Goods goods3 = new Goods("Milk", 8);
            String fileName = "files/GoodsData.txt";

            writeGoods(fileName, goods1);
            writeGoods(fileName, goods2);
            writeGoods(fileName, goods3);

            // Task 2.2
            List<String> goodsString = new ArrayList<>(readGoodsFromFile(fileName));

            for (String goods : goodsString) {
                //  System.out.println(goods);
            }
        }

        // Task 3
        {
            String filePath = "files/MovieTheatre.ser";
            MovieTheatre movieTheatre = new MovieTheatre("Arena", "Sofia", 20, 100);

            serializeMovieTheatre(filePath, movieTheatre);
            System.out.println(deserializeMovieTheatre(filePath));;
        }
    }
}
