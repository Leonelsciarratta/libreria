package com.example.miAplicacion.repositorios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.miAplicacion.entidades.Libro;
@Repository
public interface LibroRep extends JpaRepository<Libro, Integer>{

}
