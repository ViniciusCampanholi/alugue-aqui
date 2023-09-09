package com.alugue.aqui.repository;

import org.springframework.data.jpa.domain.Specification;

import com.alugue.aqui.entity.ClientApartments;

public class ClientApartmentSpecification {
    public static Specification<ClientApartments> cityContainsIgnoreCase(String city){
        return (root, query, criteriaBuilder) -> 
            criteriaBuilder.like(criteriaBuilder.lower(root.get("city")),
            "%" + city.toLowerCase() + "%"
        ); 
    }

    public static Specification<ClientApartments> rentPrinceBetween(Integer minPrice, Integer maxPrice){
        return (root, query, criteriaBuilder) ->
            criteriaBuilder.between(root.get("rentPrice"), minPrice, maxPrice
        );
    }

    public static Specification<ClientApartments> isAvailableForRent(Boolean isAvailable){
        return (root, query, criteriaBuilder) ->
            criteriaBuilder.equal(
                root.get("isAvailableForRent"), isAvailable
            );
    }
}