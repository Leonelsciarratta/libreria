package com.example.miAplicacion.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainControlador {
@GetMapping ("/")	
public String index() {
	return"index.html";
}
@GetMapping ("/autor/registro")	
public String autor() {
	return"crearAutor.html";
}

@GetMapping ("/autor/guardar")	
public String autoreditado() {
	return"ListaAutor.html";
}
@GetMapping ("/editorial/registro")	
public String editorial() {
	return"crearEditorial.html";
	
}
@GetMapping ("/cliente/registro")	
public String cliente() {
	return"crearCliente.html";
	
}

@GetMapping ("/libro/registro")	
public String libro() {
	return"crearLibro.html";
}

@GetMapping ("/autor/eliminar")	
public String autorEliminado() {
	return"index.html";
}
}
