package com.youpri.modelo;

import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
@Getter
@Builder
public class Videos {
	@Id @GeneratedValue
	private long id;
	private String Titulo;
	private String Descripcion;
	@ManyToOne
	@JoinColumn(name="categoria_id")
	private Categoria Categoria;
	@JoinColumn(name="usuario_id")
	private Optional<UserEntity> cliente;
	private String Imagen;
	private String Fichero;
	
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
	public String getImagen() {
		return Imagen;
	}
	public void setImagen(String imagen) {
		Imagen = imagen;
	}
	public String getFichero() {
		return Fichero;
	}
	public void setFichero(String fichero) {
		Fichero = fichero;
	}
}
