package com.example.miAplicacion.controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.miAplicacion.Interfaces.ErrorHandler;

import com.example.miAplicacion.entidades.Cliente;
import com.example.miAplicacion.errores.ErrorServicio;
import com.example.miAplicacion.servicios.ClienteServicio;
@Controller
@RequestMapping("/cliente")
public class clienteControlador implements ErrorHandler {
		@Autowired
		private ClienteServicio servCliente;

		@PostMapping("/registro")
		public String guardarCliente(@RequestParam("documento") Long documento,@RequestParam("nombre") String nombre,@RequestParam("apellido") String apellido,@RequestParam("telefono")String telefono) throws ErrorServicio {
			servCliente.crearCliente(documento,nombre,apellido,telefono);
			return ("redirect:/");
		}

		@GetMapping("/lista")
		public String listar(ModelMap modelo) {
			List<Cliente> listaClient = servCliente.listaClientes();
			modelo.addAttribute("listaClientes", listaClient);
			return "ListaCliente.html";
		}

		@GetMapping("/eliminar/{id}")
		public String borrar(@PathVariable("id") Integer id) {
			servCliente.eliminarCliente(id);
			return "redirect:/";
		}

		@PostMapping("/guardar")
		public String guardar(@Validated Cliente c) {
			servCliente.guardar(c);
			return "ListaCliente.html";

		}
		@PostMapping("/editar/{id}")
		public String editarCliente(@PathVariable("id") Integer id,@RequestParam("documento") Long documento,@RequestParam("nombre") String nombre, @RequestParam("apellido") String apellido, @RequestParam("telefono") String telefono) {
			
			servCliente.modificarCliente(id,documento, nombre,apellido,telefono);
			return "redirect:/cliente/lista";

		}

		@GetMapping("/editar/{id}") 
		public String editar(@PathVariable("id") Integer id, ModelMap model) {
			Optional<Cliente> cliente = servCliente.listaid(id);
			Cliente miCliente = cliente.get();
			model.addAttribute("autor", miCliente);
			model.put("editar","editar cliente");
			return "editarCliente.html";

		}
		@GetMapping("/modificar/alta/{id}")
		public String modificarAlta(ModelMap model, @PathVariable("id") Integer id) {

			try {
				
				servCliente.cambiarAlta(id);

				return "redirect:/cliente/lista";

			} catch (Exception e) {

				return this.errorHandle(e, model);

			}
			

		}
		@Override
		public String errorHandle(Exception e, ModelMap model) {

			model.addAttribute("err", e.getMessage());

			return "ListaCliente.html";
		}

	}


