package com.sinami.spring6restmvc.controllers;

import com.sinami.spring6restmvc.models.Beer;
import com.sinami.spring6restmvc.models.Customer;
import com.sinami.spring6restmvc.services.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api/v1/customer")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> getAll(){
        return customerService.getAll();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Customer getById(@PathVariable("id") UUID id){
        return customerService.getById(id);
    }

    @PostMapping
    public ResponseEntity handlePost(@RequestBody Customer customer){
        Customer savedCustomer = customerService.addNewCustomer(customer);
        // This add a header of type key,value to return an response with header to see what wrong
        HttpHeaders headers = new HttpHeaders();
        headers.add("location","/api/v1/customer/"+savedCustomer.getId());
        return  new ResponseEntity(headers, HttpStatus.CREATED);
    }



    @PutMapping("/{customerId}")
    public ResponseEntity updateById(@PathVariable("customerId") UUID customerId,@RequestBody Customer customer){
        customerService.updateBeerById(customerId,customer);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
