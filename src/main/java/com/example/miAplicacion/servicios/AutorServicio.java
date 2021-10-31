package com.example.miAplicacion.servicios;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.miAplicacion.entidades.Autor;
import com.example.miAplicacion.repositorios.AutorRep;

@Service
public class AutorServicio {
	@Autowired
	private AutorRep AutorRepo;

	public void crearAutor(String nombre) {
		Autor a = new Autor();
		a.setNombre(nombre);
		a.setId(randomId());
		a.setAlta(true);
		/* subir a base de datos */
		AutorRepo.save(a);
	}

	public int randomId() {
		String uuid = UUID.randomUUID().toString();
		int id = uuid.hashCode();
		id = id < 0 ? -id : id;
		return id;
	}

	public void eliminarAutor(Integer id) {
		AutorRepo.deleteById(id);
	}

	public void modificarAutor(Integer id, String nombre) {
		Autor a = AutorRepo.findById(id).get();
		a.setNombre(nombre);
		AutorRepo.save(a); 
	}

	public List<Autor> listaAutores() {
		List<Autor> listaAutores = AutorRepo.findAll();
		return listaAutores;
	}

	public Optional<Autor> listaid(Integer id) {
		return AutorRepo.findById(id);
	}

	public int guardar(Autor a) {

		int res = 0;
		Autor autor = AutorRepo.save(a);
		if (!autor.equals(null)) {
			res = -1;
		}
		return res;
	}
	public void cambiarAlta(Integer id) throws Exception {
		Autor a = AutorRepo.findById(id).get();
		a.setAlta(!a.isAlta());
		AutorRepo.save(a); 
	}
	
}
