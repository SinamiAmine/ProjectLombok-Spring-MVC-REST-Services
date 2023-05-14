package com.sinami.spring6restmvc.controllers;


import com.sinami.spring6restmvc.models.Beer;
import com.sinami.spring6restmvc.services.BeerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {
    private final BeerService beerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Beer> listBeers(){
        return beerService.listBeers();
    }
    @RequestMapping(value = "/{beerId}",method = RequestMethod.GET)
    public Beer getBeerById(@PathVariable("beerId") UUID beerId){
        log.debug("Get Beer By Id - In The Controller");
        return beerService.getBeerById(beerId);
    }

    //@RequestMapping(method = RequestMethod.POST)
    @PostMapping
    public ResponseEntity handlePost(@RequestBody Beer beer){
        Beer savedBeer = beerService.saveNewBeer(beer);
        // This add a header of type key,value to return an response with header to see what wrong
        HttpHeaders headers = new HttpHeaders();
        headers.add("location","/api/v1/beer/"+savedBeer.getId());
        return  new ResponseEntity(headers,HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity updateById(@PathVariable("beerId") UUID beerId,@RequestBody Beer beer){
        beerService.updateBeerById(beerId,beer);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


    @DeleteMapping("{beerId}")
    public ResponseEntity deleteById(@PathVariable("beerId") UUID beerId){
        beerService.deleteById(beerId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }



    @PatchMapping("/{beerId}")
    public ResponseEntity updateBeerPatchById(@PathVariable("beerId") UUID beerId,@RequestBody Beer beer){
        beerService.patchBeerById(beerId,beer);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


}
