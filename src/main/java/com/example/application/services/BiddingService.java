package com.example.application.services;

import com.example.application.data.Bidding;
import com.example.application.data.BiddingRepository;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import dev.hilla.BrowserCallable;

import java.util.List;

@BrowserCallable
@AnonymousAllowed
public class BiddingService {

    private final BiddingRepository biddingRepository;

    public BiddingService(BiddingRepository biddingRepository) {
        this.biddingRepository = biddingRepository;
    }

    public List<Bidding> getBidList(){
        return biddingRepository.findAll();
    }
}
