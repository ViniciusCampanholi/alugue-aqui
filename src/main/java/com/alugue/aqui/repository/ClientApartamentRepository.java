package com.alugue.aqui.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.alugue.aqui.entity.ClientApartments;

public interface ClientApartamentRepository extends JpaRepository<ClientApartments, UUID>, JpaSpecificationExecutor<ClientApartments>{

}