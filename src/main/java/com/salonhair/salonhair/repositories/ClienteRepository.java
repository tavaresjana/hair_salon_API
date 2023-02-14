package com.salonhair.salonhair.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salonhair.salonhair.entities.ClienteModel;

public interface ClienteRepository extends JpaRepository<ClienteModel, Long>{

}
