package com.example.miAplicacion.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cliente {
@Id
private Integer id;
private Long documento;
private String nombre;
private String apellido;
private String telefono;
private boolean alta;

public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public Long getDocumento() {
	return documento;
}
public void setDocumento(Long documento) {
	this.documento = documento;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getApellido() {
	return apellido;
}
public void setApellido(String apellido) {
	this.apellido = apellido;
}
public String getTelefono() {
	return telefono;
}
public void setTelefono(String telefono) {
	this.telefono = telefono;
}
public boolean isAlta() {
	return alta;
}
public void setAlta(boolean alta) {
	this.alta = alta;
}

}
