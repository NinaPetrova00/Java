package com.citb408.Paper;

import java.math.BigDecimal;

public enum PaperType {
    NORMAL(BigDecimal.valueOf(0.10)),
    GLOSSY(BigDecimal.valueOf(0.15)),
    NEWSPRINT(BigDecimal.valueOf(0.05));
    private BigDecimal pricePerType;

    PaperType(BigDecimal pricePerType) {
        this.pricePerType = pricePerType;
    }

    public BigDecimal getPricePerType() {
        return pricePerType;
    }

    public void setPricePerType(BigDecimal pricePerType) {
        this.pricePerType = pricePerType;
    }
}
