package com.youpri.rest.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VideosDTO {
	private String Titulo;
	private String Descripcion;
	private String categoriaNombre;
	private String usuarioNombre;
	private String Imagen;
	
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
	public String getCategoriaNombre() {
		return categoriaNombre;
	}
	
	public void setCategoriaNombre(String categoriaNombre) {
		this.categoriaNombre = categoriaNombre;
	}
	
	public String getUsuarioNombre() {
		return usuarioNombre;
	}
	public void setUsuarioNombre(String usuarioNombre) {
		this.usuarioNombre = usuarioNombre;
	}
	
	public String getImagen() {
		return Imagen;
	}
	public void setImagen(String imagen) {
		Imagen = imagen;
	}
}
