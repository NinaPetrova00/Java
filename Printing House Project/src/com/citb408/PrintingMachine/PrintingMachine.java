package com.citb408.PrintingMachine;

import com.citb408.Publication.Publication;

import java.util.ArrayList;
import java.util.List;

public class PrintingMachine implements Runnable {
    private int maxNumberOfPaper;
    private PrintingType printingType;
    private String machineName;
    private List<Publication> publicationList;
    private Thread thread;

    public PrintingMachine(int maxNumberOfPaper, PrintingType printingType, String machineName) {
        this.maxNumberOfPaper = maxNumberOfPaper;
        this.printingType = printingType;
        this.machineName = machineName;
        this.publicationList = new ArrayList<>();
        thread = new Thread("Printing Thread");
        thread.start();
    }

    public int getMaxNumberOfPaper() {
        return maxNumberOfPaper;
    }

    public void setMaxNumberOfPaper(int maxNumberOfPaper) {
        this.maxNumberOfPaper = maxNumberOfPaper;
    }

    public PrintingType getPrintingType() {
        return printingType;
    }

    public List<Publication> getPublicationList() {
        return publicationList;
    }

    public String getMachineName() {
        return machineName;
    }

    public void printing() throws InsufficientPaperException {
        int paperLeft = this.maxNumberOfPaper;
        for (Publication publication : this.publicationList) {

            if (paperLeft > publication.getNumberOfPages()) {
                paperLeft -= publication.getNumberOfPages();
            } else {
                throw new InsufficientPaperException(publication.getNumberOfPages(), this.maxNumberOfPaper);
            }
        }
    }

    // method to add publications in the machine
    public void addPublicationInMachine(Publication publication) {
        if (!this.publicationList.contains(publication)) {
            this.publicationList.add(publication);
        }
    }

    @Override
    public void run() {
        for (int i = 1; i < this.maxNumberOfPaper; i++) {
            for (Publication publication : this.publicationList) {
                System.out.println(Thread.currentThread().getName() + " " + this.machineName + " printed " + i + " page" +
                        " of publication '" + publication.getTitle() + "'");
            }
        }
    }

    @Override
    public String toString() {
        return "PrintingMachine{" +
                "maxNumberOfPaper=" + maxNumberOfPaper +
                ", printingType=" + printingType +
                ", machineName='" + machineName + '\'' +
                ", publicationList=" + publicationList +
                ", thread=" + thread +
                '}';
    }
}
