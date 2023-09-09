package com.alugue.aqui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alugue.aqui.entity.Client;
import com.alugue.aqui.entity.ClientApartments;
import com.alugue.aqui.service.ApartamentService;

@RestController
@RequestMapping(value = "/alugueaqui")
public class ApartamentRestController {

    @Autowired
    private ApartamentService apartamentService;

    @GetMapping({"/api/clients", "/api/clients/{optinalClientId}"})
    public ResponseEntity<List<Client>> findAllClients(@PathVariable(required = false, name = "optinalClientId") String optinalClientId) {
        return apartamentService.getClients(optinalClientId);
    }

    @GetMapping("api/apartments")
    public ResponseEntity<List<ClientApartments>> findAllApartments(
        @RequestParam(required = false, name = "city") String city,
        @RequestParam(required = false, name = "minPrice") Integer minPrice,
        @RequestParam(required = false, name = "maxPrice") Integer maxPrice,
        @RequestParam(required = false, name = "isAvailableForRent") Boolean isAvaliableForRent
        ){
        return apartamentService.getApartments(city, minPrice, maxPrice, isAvaliableForRent);
    }
}