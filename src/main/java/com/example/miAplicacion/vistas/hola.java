package com.example.miAplicacion.vistas;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController 
public class hola {
	@GetMapping
	public String saludos(@RequestParam(required = false, defaultValue = "") String nombre) {
        return "".equals(nombre) ? "Hola Mundo!" : "Hola " + nombre;
        
    }
}


