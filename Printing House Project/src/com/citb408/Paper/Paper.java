package com.citb408.Paper;

import java.math.BigDecimal;

public class Paper {
    private PaperSize size;
    private PaperType type;

    public Paper(PaperSize size, PaperType type) {
        this.size = size;
        this.type = type;
    }

    public PaperSize getSize() {
        return size;
    }

    public PaperType getType() {
        return type;
    }

    public BigDecimal calculatePaperPrice(){
        return this.size.getPricePerSize().add(this.type.getPricePerType());
    }

    @Override
    public String toString() {
        return "Paper{" +
                "size=" + size +
                ", type=" + type +
                '}';
    }
}
