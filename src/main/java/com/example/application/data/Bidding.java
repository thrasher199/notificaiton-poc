package com.example.application.data;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "bidding")
public class Bidding extends AbstractEntity {
    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Column(name = "bid_amount", nullable = false, precision = 19, scale = 2)
    private BigDecimal bidAmount;

    public BigDecimal getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(BigDecimal bidAmount) {
        this.bidAmount = bidAmount;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}