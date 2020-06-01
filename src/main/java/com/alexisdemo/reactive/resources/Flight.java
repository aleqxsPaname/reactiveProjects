package com.alexisdemo.reactive.resources;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Flight {

    String departure;
    String arrival;
    Double price;
    LocalDateTime departureDateTime;

    public Flight fromAndTo(String departure, String arrival){
        this.departure = departure;
        this.arrival = arrival;
        return this;
    }

    public Flight atPrice(Double price){
        this.price = price;
        return this;
    }

    public Flight atDepartureTime(LocalDateTime departureDateTime){
        this.departureDateTime = departureDateTime;
        return this;
    }

}
