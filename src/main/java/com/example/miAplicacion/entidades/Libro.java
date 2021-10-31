package com.example.miAplicacion.entidades;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Libro {
	@Id
	private Integer id;
	private Long isbn;
	private String titulo;
	private Integer anio;
	private Integer ejemplares;
    private Integer ejemplares_prestados;
    private Integer ejemplares_restantes;
    private boolean alta; 
    
    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Long getIsbn() {
		return isbn;
	}
	public void setIsbn(Long isbn) {
		this.isbn = isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Integer getAnio() {
		return anio;
	}
	public void setAnio(Integer anio) {
		this.anio = anio;
	}
	public Integer getEjemplares() {
		return ejemplares;
	}
	public void setEjemplares(Integer ejemplares) {
		this.ejemplares = ejemplares;
	}
	public Integer getEjemplares_prestados() {
		return ejemplares_prestados;
	}
	public void setEjemplares_prestados(Integer ejemplares_prestados) {
		this.ejemplares_prestados = ejemplares_prestados;
	}
	public Integer getEjemplares_restantes() {
		return ejemplares_restantes;
	}
	public void setEjemplares_restantes(Integer ejemplares_restantes) {
		this.ejemplares_restantes = ejemplares_restantes;
	}
	public boolean isAlta() {
		return alta;
	}
	public void setAlta(boolean alta) {
		this.alta = alta;
	}
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	public Editorial getEditorial() {
		return editorial;
	}
	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}
	@OneToOne
    private Autor autor;
    @OneToOne
    private Editorial editorial;
}

