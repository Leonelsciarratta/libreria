package com.example.miAplicacion.controladores;

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
import com.example.miAplicacion.entidades.Libro;
import com.example.miAplicacion.servicios.LibroServicio;

@Controller
@RequestMapping("/libro")
public class LibroControlador implements ErrorHandler{
@Autowired	
private LibroServicio servLibro;	
@PostMapping("/registro")	
public String guardarEditorial(@RequestParam("isbn") Long isbn, @RequestParam("titulo") String titulo, @RequestParam("anio") Integer anio,  @RequestParam("ejemplares") Integer ejemplares,  @RequestParam("ejemplares_prestados") Integer ejemplares_prestados,  @RequestParam("ejemplares_restantes") Integer ejemplares_restantes) {
	servLibro.crearLibro(isbn,titulo,anio, ejemplares,ejemplares_prestados, ejemplares_restantes);
	return("redirect:/");
}
@GetMapping("/lista")
public String listar(ModelMap modelo) {
	List<Libro> listalib=servLibro.listaLibros();
	modelo.addAttribute("listaLibros",listalib);
	return "ListaLibro.html";
}

@GetMapping("/eliminar/{id}")
public String borrar(@PathVariable("id") Integer id){
    servLibro.eliminarLibro(id);
    return "redirect:/";
}
@PostMapping("/guardar")
public String guardar(@Validated Libro l, Model model) {
	servLibro.guardar(l);
	return "ListaLibro.html";
	
}
@PostMapping("/editar/{id}")
public String editarLibro(@PathVariable("id") String id, @RequestParam("isbn") Long  isbn,@RequestParam("titulo") String titulo, @RequestParam("anio") Integer anio,@RequestParam("ejemplares") Integer ejemplares , @RequestParam("ejemplares_prestados") Integer ejemplares_prestados , @RequestParam("ejemplares_restantes") Integer ejemplares_restantes) {
	Integer intId = Integer.parseInt(id);
	servLibro.modificarLibro(intId,isbn,titulo,anio, ejemplares,ejemplares_prestados, ejemplares_restantes);
	return "redirect:/libro/lista";

}

@GetMapping("/editar/{id}") 
public String editar(@PathVariable("id") String id, ModelMap model) {
	Integer intId = Integer.parseInt(id);
	Optional<Libro> libro = servLibro.listaid(intId);
	Libro miLibro = libro.get();
	model.addAttribute("libro", miLibro);
	model.put("editar","editar libro");
	return "editarLibro.html";

}
@GetMapping("/modificar/alta/{id}")
public String modificarAlta(ModelMap model, @PathVariable("id") String id) {

	try {
		Integer intId = Integer.parseInt(id);
		servLibro.cambiarAlta(intId);

		return "redirect:/libro/lista";

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
