package com.alugue.aqui.entity;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "client_apartments")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClientApartments {

    @Id
    private UUID apartmentId;

    private String description;

    private String buildingName;

    private String streetAddress;

    private String city;

    private String postalCode;

    private Boolean isAvailableForRent;

    private Integer rentPrice;

}
