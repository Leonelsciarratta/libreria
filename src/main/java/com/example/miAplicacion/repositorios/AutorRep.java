package com.example.miAplicacion.repositorios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.miAplicacion.entidades.Autor;
@Repository
public interface AutorRep extends JpaRepository<Autor, Integer>{

}
