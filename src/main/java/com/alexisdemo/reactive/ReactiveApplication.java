package com.alexisdemo.reactive;


import com.alexisdemo.reactive.resources.Flight;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.LocalDateTime;


@SpringBootApplication
@RestController
public class ReactiveApplication {

    public static void main(String[] args){
        SpringApplication.run(ReactiveApplication.class, args);
    }

    @GetMapping("/namesOfDeveloper")
    public String getNamesOfDeveloper() {
        return "Alexis the Developer";
    }

    @GetMapping(value = "/airfrance/vols/paris", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Flight> getFlightsOfAirFrance() {
        Flux<Flight> vols = Flux
                .just(
                      new Flight("Paris", "New York", 750.0, LocalDateTime.of(2020, 6,20,10,33)),
                      new Flight("Paris", "New York", 750.0, LocalDateTime.of(2020, 6,20,11,10)),
                      new Flight().fromAndTo("Paris","SanFrancisco")
                               .atPrice(970.0)
                               .atDepartureTime(LocalDateTime.of(2020, 6,20,14,42))
                        )
                .delayElements(Duration.ofMillis(1000))
                ;
        return vols;
    }

    @GetMapping(value = "/quatarairways/vols/paris", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Flight> getFlightsOfQuatarAirWays() {
        Flux<Flight> vols = Flux
                .just(
                        new Flight("Paris", "Singapoor", 750.0, LocalDateTime.of(2020, 6,20,11,20)),
                        new Flight("Paris", "Dubai", 450.0, LocalDateTime.of(2020, 6,20,15,30)),
                        new Flight().fromAndTo("Paris","HongKong")
                                .atPrice(570.0)
                                .atDepartureTime(LocalDateTime.of(2020, 6,20,18,42))
                )
            //    .delayElements(Duration.ofMillis(1300))
                ;
        return vols;
    }





}
