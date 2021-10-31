
package com.example.miAplicacion.controladores;
import com.example.miAplicacion.servicios.EditorialServicio;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.miAplicacion.Interfaces.ErrorHandler;
import com.example.miAplicacion.entidades.Autor;
import com.example.miAplicacion.entidades.Editorial;

@Controller
@RequestMapping("/editorial")
public class EditorialControlador implements ErrorHandler{
@Autowired
private EditorialServicio servEditorial;	
@PostMapping("/registro")	
public String guardarEditorial(@RequestParam("nombre") String nombre) {
	servEditorial.crearEditorial(nombre);
	return("redirect:/");
}

@GetMapping("/lista")
public String listar(ModelMap modelo) {
	List<Editorial> listaEdit=servEditorial.listaEditoriales();
	modelo.addAttribute("listaEditoriales",listaEdit);
	return "ListaEditorial.html";
}

@GetMapping("/eliminar/{id}")
public String borrar(@PathVariable("id") Integer id){
    servEditorial.eliminarEditorial(id);
    return "redirect:/";
}
@PostMapping("/guardar")
public String guardar(@Validated Editorial e, Model model) {
	servEditorial.guardar(e);
	return "ListaEditorial.html";
	
}
@PostMapping("/editar/{id}")
public String editarEditorial(@PathVariable("id") String id, @RequestParam("nombre") String nombre) {
	Integer intId = Integer.parseInt(id);
	servEditorial.modificarEditorial(intId, nombre);
	return "redirect:/editorial/lista";

}

@GetMapping("/editar/{id}") 
public String editar(@PathVariable("id") String id, ModelMap model) {
	Integer intId = Integer.parseInt(id);
	Optional<Editorial> editorial = servEditorial.listaid(intId);
	Editorial miEditorial = editorial.get();
	model.addAttribute("editorial", miEditorial);
	model.put("editar","editar editorial");
	return "editarEditorial.html";

}
@GetMapping("/modificar/alta/{id}")
public String modificarAlta(ModelMap model, @PathVariable("id") String id) {

	try {
		Integer intId = Integer.parseInt(id);
		servEditorial.cambiarAlta(intId);

		return "redirect:/editorial/lista";

	} catch (Exception e) {

		return this.errorHandle(e, model);

	}
	

}
@Override
public String errorHandle(Exception e, ModelMap model) {

	model.addAttribute("err", e.getMessage());

	return "ListaAutor.html";
}
}

