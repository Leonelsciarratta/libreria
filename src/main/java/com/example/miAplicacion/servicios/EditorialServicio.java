package com.example.miAplicacion.servicios;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.miAplicacion.entidades.Autor;
import com.example.miAplicacion.entidades.Editorial;
import com.example.miAplicacion.repositorios.EditorialRep;
@Service
public class EditorialServicio {
@Autowired	
private EditorialRep EditorialRepo;
public void crearEditorial(String nombre) {
Editorial e = new Editorial();
e.setNombre(nombre);
e.setId(randomId());
e.setAlta(true);
//subir a base de datos
EditorialRepo.save(e);
}
public int randomId() {
	String uuid=UUID.randomUUID().toString();
	int id=uuid.hashCode();
	id=id<0?-id:id;
    return id;}
public void eliminarEditorial(Integer id) {
	EditorialRepo.deleteById(id);
}
public void modificarEditorial(Integer id, String nombre) {
	Editorial e= EditorialRepo.findById(id).get();
	e.setNombre(nombre);
	EditorialRepo.save(e);
	
}
public List<Editorial> listaEditoriales(){
	List<Editorial> listaEditoriales=EditorialRepo.findAll();
	return listaEditoriales;
}
public Optional <Editorial> listaid(Integer id){
	return EditorialRepo.findById(id);
}
public int guardar(Editorial e) {
	
	int res =0;
	Editorial editorial=EditorialRepo.save(e);
	if(!editorial.equals(null)) {
		res=-1;
	}
	return res;
}
public void cambiarAlta(Integer id) throws Exception {
	Editorial e = EditorialRepo.findById(id).get();
	e.setAlta(!e.isAlta());
	EditorialRepo.save(e); 
}
}

