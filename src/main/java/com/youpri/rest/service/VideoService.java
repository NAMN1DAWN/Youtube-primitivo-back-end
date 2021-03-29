package com.youpri.rest.service;

import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.youpri.controller.FicherosController;
import com.youpri.modelo.Categoria;
import com.youpri.modelo.CategoriaRepositorio;
import com.youpri.modelo.UserEntity;
import com.youpri.modelo.UserRepositorio;
import com.youpri.modelo.Videos;
import com.youpri.modelo.VideosRepositorio;
import com.youpri.rest.dto.CreateVideos;
import com.youpri.rest.dto.VideosDTO;
import com.youpri.rest.dto.converter.VideosDTOConverter;
import com.youpri.rest.service.subida.StorageService;


@Service
public class VideoService {

	static VideosRepositorio videosRepositorio = null;

	private final static CategoriaRepositorio categoriaRepositorio = null;
	
	final static VideosDTOConverter videosDTOConverter = null;
	
	final CustomUserDetailsService customUserDetailsService = null;
	
	final static UserEntityService userEntityService = null;
	
	final UserRepositorio userRepositorio = null;
	
	Optional<UserEntity> usuario = null;
	
	final static StorageService storageService= null;
	
	public static VideosDTO crearVideos(CreateVideos nuevo, MultipartFile file, MultipartFile fichero) {
		String urlImagen = null;
		String urlFichero = null;
		
		if(!file.isEmpty() && !fichero.isEmpty()) 
		{
			String imagen = storageService.store(file);
			urlImagen = MvcUriComponentsBuilder
					.fromMethodName(FicherosController.class, "serveFile", imagen, null)
					.build().toUriString();
			
			String video = storageService.store(fichero);
			urlFichero = MvcUriComponentsBuilder
					.fromMethodName(FicherosController.class, "serverFile", video, null)
					.build().toString();
			
		}
	    Videos nuevoVideo = new Videos();
	    nuevoVideo.setTitulo(nuevo.getTitulo());
	    nuevoVideo.setDescripcion(nuevo.getDescripcion());
	    Categoria categoria = categoriaRepositorio.findById(nuevo.getCategoriaId()).orElse(null);
	    nuevoVideo.setCategoria(categoria);
	    nuevoVideo.setCliente(BusquedaId());
	    nuevoVideo.setImagen(urlImagen);
	    nuevoVideo.setFichero(urlFichero);
	    videosRepositorio.save(nuevoVideo);
	    VideosDTO videosDTO = videosDTOConverter.convertToDto(nuevoVideo);
	    return videosDTO;
	}
	
	private static Optional<UserEntity> BusquedaId() {
		Optional<UserEntity> usuario = null;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		usuario = userEntityService.findByUsername(userDetail.getUsername());
		
		return usuario;
	}
}
