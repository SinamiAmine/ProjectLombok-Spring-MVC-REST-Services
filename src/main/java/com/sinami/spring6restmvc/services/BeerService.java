package com.sinami.spring6restmvc.services;

import com.sinami.spring6restmvc.models.Beer;

import java.util.List;
import java.util.UUID;


public interface BeerService {
    List<Beer> listBeers();

    Beer getBeerById(UUID id);

    Beer saveNewBeer(Beer beer);

    void updateBeerById(UUID beerId, Beer beer);

    void deleteById(UUID beerId);

    void patchBeerById(UUID beerId, Beer beer);
}
