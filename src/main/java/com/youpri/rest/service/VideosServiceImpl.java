package com.youpri.rest.service;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.youpri.modelo.Categoria;
import com.youpri.modelo.CategoriaRepositorio;
import com.youpri.modelo.Videos;
import com.youpri.modelo.VideosRepositorio;
import com.youpri.rest.dto.CreateVideos;
import com.youpri.rest.dto.VideosDTO;
import com.youpri.rest.dto.converter.VideosDTOConverter;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public abstract class VideosServiceImpl implements VideosService{

	@Autowired
	private VideosRepositorio videosRepositorio;
	@Autowired
	private CategoriaRepositorio categoriaRepositorio;
	
	private final VideosDTOConverter videosDTOConverter = null;

	public VideosDTO crearVideos(CreateVideos nuevo) {
	    Videos nuevoVideo = new Videos();
	    nuevoVideo.setTitulo(nuevo.getTitulo());
	    nuevoVideo.setDescripcion(nuevo.getDescripcion());
	    Categoria categoria = categoriaRepositorio.findById(nuevo.getCategoriaId()).orElse(null);
	    nuevoVideo.setCategoria(categoria);
	    videosRepositorio.save(nuevoVideo);
	    VideosDTO videosDTO = videosDTOConverter.convertToDto(nuevoVideo);
	    return videosDTO;
	}
}
