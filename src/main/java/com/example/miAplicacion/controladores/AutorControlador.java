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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.miAplicacion.servicios.AutorServicio;
import com.example.miAplicacion.Interfaces.ErrorHandler;
import com.example.miAplicacion.entidades.*;

@Controller
@RequestMapping("/autor")
public class AutorControlador implements ErrorHandler {
	@Autowired
	private AutorServicio servAutor;

	@PostMapping("/registro")
	public String guardarAutor(@RequestParam("nombre") String nombre) {
		servAutor.crearAutor(nombre);
		return ("redirect:/");
	}

	@GetMapping("/lista")
	public String listar(ModelMap modelo) {
		List<Autor> listaAut = servAutor.listaAutores();
		modelo.addAttribute("listaAutores", listaAut);
		return "ListaAutor.html";
	}

	@GetMapping("/eliminar/{id}")
	public String borrar(@PathVariable("id") Integer id) {
		servAutor.eliminarAutor(id);
		return "redirect:/";
	}

	@PostMapping("/guardar")
	public String guardar(@Validated Autor a) {
		servAutor.guardar(a);
		return "ListaAutor.html";

	}
	@PostMapping("/editar/{id}")
	public String editarAutor(@PathVariable("id") String id, @RequestParam("nombre") String nombre) {
		Integer intId = Integer.parseInt(id);
		servAutor.modificarAutor(intId, nombre);
		return "redirect:/autor/lista";

	}

	@GetMapping("/editar/{id}") 
	public String editar(@PathVariable("id") String id, ModelMap model) {
		Integer intId = Integer.parseInt(id);
		Optional<Autor> autor = servAutor.listaid(intId);
		Autor miAutor = autor.get();
		model.addAttribute("autor", miAutor);
		model.put("editar","editar autor");
		return "editarAutor.html";

	}
	@GetMapping("/modificar/alta/{id}")
	public String modificarAlta(ModelMap model, @PathVariable("id") String id) {

		try {
			Integer intId = Integer.parseInt(id);
			servAutor.cambiarAlta(intId);

			return "redirect:/autor/lista";

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
