package com.example.miAplicacion.repositorios;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.miAplicacion.entidades.Cliente;

@Repository
public interface ClienteRep extends JpaRepository<Cliente, Integer> {

	

	

}
