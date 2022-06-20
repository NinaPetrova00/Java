package com.citb408.Publication;

import com.citb408.Paper.Paper;

import java.math.BigDecimal;

public class Publication {
    private PublicationType publicationType;
    private String title;
    private int numberOfPages;
    private Paper paper;
    private BigDecimal overcharge; // надценка над цената

    public Publication(PublicationType publicationType, String title, int numberOfPages, Paper paper, BigDecimal overcharge) {
        this.publicationType = publicationType;
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.paper = paper;
        this.overcharge = overcharge;
    }

    public PublicationType getPublicationType() {
        return publicationType;
    }

    public String getTitle() {
        return title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public Paper getPaper() {
        return paper;
    }

    public BigDecimal getOvercharge() {
        return overcharge;
    }

    // method for calculating the price for one publication
    public BigDecimal pricePerPublication() {
        BigDecimal paperPrice = this.paper.calculatePaperPrice();
        BigDecimal price = paperPrice.multiply(BigDecimal.valueOf(this.numberOfPages));
        BigDecimal priceIncreasement = this.overcharge.divide(BigDecimal.valueOf(100));

        return price.add(price.multiply(priceIncreasement));
    }

    // method for calculating expenses for Paper
    public BigDecimal expensesForPaper() {
        return BigDecimal.valueOf(this.numberOfPages).multiply(this.paper.calculatePaperPrice());
    }

    @Override
    public String toString() {
        return "Publication{" +
                "publicationType=" + publicationType +
                ", title='" + title + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", paper=" + paper +
                ", overcharge=" + overcharge +
                '}';
    }
}
