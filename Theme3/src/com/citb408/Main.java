package com.citb408;

import com.citb408.building.Building;
import com.citb408.building.Premise;
import com.citb408.building.Room;
import com.citb408.repo.*;

public class Main {

    public static void main(String[] args) {
     /*   Document document1 = new Document("Doc 1",3.4,".pdf");

        System.out.println(document1);

        Author author = new Author("Ivan Vazov");

        Book book1 = new Book();
       // Book book2 = new Book("Book 2",5.6,".txt","TYU#%79", new Author("Botev")); // тук автора не се пази
        Book book2 = new Book("Book 2",5.6,".txt","TYU#%79", author); // тук автора се пази
        System.out.println(book1);
        System.out.println(book2);

        Novel novel1 = new Novel("Pod Igoto",7.8,".pdf","ASD2252",author,"Abstract");
        System.out.println(novel1);

        Newspaper newspaper = new Newspaper("24 chasa",1.2,".pdf",20);
        System.out.println(newspaper);

        Document documentRef;
        documentRef = new Document("Doc 3",2.8,".txt");
        System.out.println(documentRef);
        documentRef = new Book("ATS6",author);
        System.out.println(documentRef);

        Repo repo = new Repo(10,0,0);
        System.out.println(repo);
        repo.uploadDocument(document1);
        repo.uploadDocument(book2);
        repo.uploadDocument(novel1);
        System.out.println(repo);*/

        Building building = new Building(200);
        Premise premise = new Premise(building, 20);
        Room room = new Room(building, 24, 2);

        Premise premiseRef;
        premiseRef = premise;
        premiseRef.capacity();
        premiseRef = room;
        premiseRef.capacity();
    }
}
