package com.youpri.rest.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateVideos {
	private String Titulo;
	private String Descripcion;
	private long categoriaId;
	private long usuarioId;
	
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
	public long getCategoriaId() {
		return categoriaId;
	}
	public void setCategoriaId(long categoriaId) {
		this.categoriaId = categoriaId;
	}
	public long getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(long usuarioId) {
		this.usuarioId = usuarioId;
	}
	
}
