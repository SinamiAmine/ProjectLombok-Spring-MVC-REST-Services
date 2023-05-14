package com.sinami.spring6restmvc.models;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class Beer {
  /*  Exemple UUID Value : 550e8400-e29b-11d4-a716-446655440000
      6ba7b810-9dad-11d1-80b4-00c04fd430c8
      123e4567-e89b-12d3-a456-556642440000*/
    private UUID id;
    private Integer version;
    private String beerName;
    private BeerStyle beerStyle;
    private String upc;
    private Integer quantityOnHand;
    private BigDecimal price;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

}
