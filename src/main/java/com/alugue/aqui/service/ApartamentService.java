package com.alugue.aqui.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.alugue.aqui.entity.Client;
import com.alugue.aqui.entity.ClientApartments;
import com.alugue.aqui.repository.ClientApartamentRepository;
import com.alugue.aqui.repository.ClientApartmentSpecification;
import com.alugue.aqui.repository.ClientRepository;

@Service
public class ApartamentService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientApartamentRepository clientApartamentRepository;
    
    public ResponseEntity<List<Client>> getClients(String optinalClientId){
        if(optinalClientId != null){
            var ClientIds = List.of(UUID.fromString(optinalClientId));
            return ResponseEntity.ok().body(clientRepository.findAllById(ClientIds));
        } else {
            return ResponseEntity.ok().body(clientRepository.findAll());
        }
    }

    public ResponseEntity<List<ClientApartments>> getApartments(String city, Integer minPrice, Integer maxPrice, Boolean isAvaliableForRentBoolean){
        Specification<ClientApartments> specification = Specification.where(null);

        if(city != null){
            specification = specification.and(ClientApartmentSpecification.cityContainsIgnoreCase(city));
        }
        if(minPrice != null && maxPrice != null){
            specification = specification.and(ClientApartmentSpecification.rentPrinceBetween(minPrice, maxPrice));
        }
        if(isAvaliableForRentBoolean != null){
            specification = specification.and(ClientApartmentSpecification.isAvailableForRent(isAvaliableForRentBoolean));
        }
        return ResponseEntity.ok().body(clientApartamentRepository.findAll(specification));
    }
    
}