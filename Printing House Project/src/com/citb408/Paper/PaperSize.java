package com.citb408.Paper;

import java.math.BigDecimal;

public enum PaperSize {
    A1(BigDecimal.valueOf(2)),
    A2(BigDecimal.valueOf(1)),
    A3(BigDecimal.valueOf(0.20)),
    A4(BigDecimal.valueOf(0.40)),
    A5(BigDecimal.valueOf(0.10));
    private BigDecimal pricePerSize;

    PaperSize(BigDecimal pricePerSize) {
        this.pricePerSize = pricePerSize;
    }

    public BigDecimal getPricePerSize() {
        return pricePerSize;
    }

    public void setPricePerSize(BigDecimal pricePerSize) {
        this.pricePerSize = pricePerSize;
    }
}
