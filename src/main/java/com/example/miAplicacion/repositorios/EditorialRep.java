package com.example.miAplicacion.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.miAplicacion.entidades.Editorial;

@Repository
public interface EditorialRep extends JpaRepository<Editorial, Integer> {

}
