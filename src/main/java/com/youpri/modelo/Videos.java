package com.youpri.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Videos {
	@Id @GeneratedValue
	private long id;
	private String Titulo;
	private String Descripcion;
	@ManyToOne
	@JoinColumn(name="categoria_id")
	private Categoria Categoria;
	
	public String getTitulo() {
		return Titulo;
	}
	public void setTitulo(String titulo) {
		Titulo = titulo;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public void setCategoria(Categoria categoria) {
		Categoria = categoria;
	}
}
