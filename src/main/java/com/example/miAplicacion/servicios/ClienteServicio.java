package com.example.miAplicacion.servicios;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.miAplicacion.entidades.Cliente;
import com.example.miAplicacion.repositorios.ClienteRep;

@Service
public class ClienteServicio {
@Autowired
private ClienteRep ClienteRepo;
public void crearCliente(Long documento,String nombre, String apellido, String telefono) {
	Cliente c = new Cliente();
	c.setDocumento(documento);
	c.setNombre(nombre);
	c.setApellido(apellido);
	c.setTelefono(telefono);
	c.setId(randomId()); 
	c.setAlta(true);
	ClienteRepo.save(c);
}

public int randomId() {
	String uuid = UUID.randomUUID().toString();
	int id = uuid.hashCode();
	id = id < 0 ? -id : id;
	return id;
}

public void eliminarCliente(Integer id) {
ClienteRepo.deleteById(id);;
}

public void modificarCliente(Integer id,Long documento,String nombre, String apellido, String telefono) {
	Cliente c = ClienteRepo.findById(id).get();
	c.setDocumento(documento);
	c.setNombre(nombre);
	c.setApellido(apellido);
	c.setTelefono(telefono);
	c.setAlta(true);
	ClienteRepo.save(c);
}


public List<Cliente> listaClientes() {
	List<Cliente> listaClientes = ClienteRepo.findAll();
	return listaClientes;
}

public Optional<Cliente> listaid(Integer id) {
	return ClienteRepo.findById(id);
}

public int guardar(Cliente c) {

	int res = 0;
	Cliente cliente = ClienteRepo.save(c);
	if (!cliente.equals(null)) {
		res = -1;
	}
	return res;
}
public void cambiarAlta(Integer id) throws Exception {
	Cliente c = ClienteRepo.findById(id).get();
	c.setAlta(!c.isAlta());
	ClienteRepo.save(c); 
}
}
