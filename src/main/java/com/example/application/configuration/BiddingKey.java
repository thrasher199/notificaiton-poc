package com.example.application.configuration;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class BiddingKey {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
