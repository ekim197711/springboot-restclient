package com.codeinvestigator.springbootrestclient.clientspace;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/station")
public class SpaceStationController {


    @GetMapping("/")
    public SpacestationResponse station(){
        RestTemplate restTemplate = new RestTemplate();
        URI uri = URI.create("http://localhost:8090/spaceship/");

        List shipsNonGeneric = restTemplate.getForObject(uri, List.class);
        List<SpaceShip> shipsGeneric = new ArrayList<>();
        shipsNonGeneric.forEach(v -> {
            if (shipsGeneric instanceof SpaceShip)
                shipsGeneric.add((SpaceShip)v);
        });

        ResponseEntity<List<SpaceShip>> exchange = restTemplate.exchange(uri, HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<SpaceShip>>() {});
        List<SpaceShip> ships = exchange.getBody();

        SpacestationResponse response = new SpacestationResponse(ships, "Everything is fine");
        return response;
    }

}
