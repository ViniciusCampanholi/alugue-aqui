package com.alugue.aqui.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alugue.aqui.entity.Client;

public interface ClientRepository extends JpaRepository<Client, UUID> {

}