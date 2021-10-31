package com.example.miAplicacion.servicios;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.miAplicacion.entidades.Autor;
import com.example.miAplicacion.entidades.Libro;
import com.example.miAplicacion.repositorios.LibroRep;
@Service
public class LibroServicio {
@Autowired	
private LibroRep LibroRepo;
public void crearLibro(Long isbn, String titulo,Integer anio, Integer ejemplares, Integer ejemplares_prestados, Integer ejemplares_restantes) {
Libro l = new Libro();
l.setIsbn(isbn);
l.setTitulo(titulo);
l.setAnio(anio);
l.setEjemplares(ejemplares);
l.setEjemplares_prestados(ejemplares_prestados);
l.setEjemplares_restantes(ejemplares_restantes);
l.setId(randomId());
l.setAlta(true);
//subir a base de datos
LibroRepo.save(l);
}
public int randomId() {
	String uuid=UUID.randomUUID().toString();
	int id=uuid.hashCode();
	id=id<0?-id:id;
    return id;}
public void eliminarLibro(Integer id) {
	LibroRepo.deleteById(id);
}
public void modificarLibro(Integer id,Long isbn,String titulo, Integer anio, Integer ejemplares, Integer ejemplares_prestados, Integer ejemplares_restantes) {
	Libro l= LibroRepo.findById(id).get();
	l.setIsbn(isbn);
	l.setTitulo(titulo);
	l.setAnio(anio);
	l.setEjemplares(ejemplares);
	l.setEjemplares_prestados(ejemplares_prestados);
	l.setEjemplares_restantes(ejemplares_restantes);
	LibroRepo.save(l);
}
public List<Libro> listaLibros(){
	List<Libro> listaLibros=LibroRepo.findAll();
	return listaLibros;
}
public Optional <Libro> listaid(Integer id){
	return LibroRepo.findById(id);
}
public int guardar(Libro l) {
	
	int res =0;
	Libro libro=LibroRepo.save(l);
	if(!libro.equals(null)) {
		res=-1;
	}
	return res;
}
public void cambiarAlta(Integer id) throws Exception {
	Libro l = LibroRepo.findById(id).get();
	l.setAlta(!l.isAlta());
	LibroRepo.save(l); 
}
}

