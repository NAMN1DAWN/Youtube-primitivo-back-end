package com.youpri.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.youpri.modelo.Categoria;
import com.youpri.modelo.CategoriaRepositorio;
import com.youpri.modelo.Videos;
import com.youpri.modelo.VideosRepositorio;
import com.youpri.rest.dto.CreateVideos;
import com.youpri.rest.dto.VideosDTO;
import com.youpri.rest.dto.converter.VideosDTOConverter;
import com.youpri.rest.service.VideoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class VideosController {

	private final VideosRepositorio videosRepositorio = null;
	private final CategoriaRepositorio categoriaRepositorio = null;
	private final VideosDTOConverter videosDTOConverter = null;
	
	@GetMapping("/")
	public ResponseEntity<?> obtenerTodos(){
		List<Videos> result = videosRepositorio.findAll();
		
		if(result.isEmpty()) 
		{
			return ResponseEntity.notFound().build();
		}
		else 
		{
			List<VideosDTO> dtoList = result.stream().map(videosDTOConverter::convertToDto).collect(Collectors.toList());
			return ResponseEntity.ok(dtoList);
		}
	}
	
	@GetMapping("/video/{id}")
	public ResponseEntity<?> obtenerUno(@PathVariable Long id){
		Videos result = videosRepositorio.findById(id).orElse(null);
		if(result == null) 
		{
			return ResponseEntity.notFound().build();
		}
		else 
		{
			return ResponseEntity.ok(result);
		}
	}
	
	@PostMapping(value="/subida", consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<VideosDTO> nuevoVideo(@RequestPart("nuevo") CreateVideos nuevo,
			@RequestPart("file") MultipartFile file, @RequestPart("fichero") MultipartFile fichero){
		return ResponseEntity.status(HttpStatus.CREATED).body(VideoService.crearVideos(nuevo,file,fichero));
	}
	
	@GetMapping("/subida")
	public ResponseEntity<?> obtenerCategorias(){
		List<Categoria> result = categoriaRepositorio.findAll();
		
		if(result.isEmpty()) 
		{
			return ResponseEntity.notFound().build();
		}
		else 
		{
			return ResponseEntity.ok(result);
		}
	}
	
	@PutMapping("/videos/{id}")
	public ResponseEntity<?> editarVideo(@RequestBody Videos editar, @PathVariable Long id){
		return videosRepositorio.findById(id).map(v -> {
			v.setTitulo(editar.getTitulo());
			v.setDescripcion(editar.getDescripcion());
			v.setCategoria(editar.getCategoria());
			v.setImagen(editar.getImagen());
			return ResponseEntity.ok(videosRepositorio.save(v));
		}).orElseGet(() -> {
			return ResponseEntity.notFound().build();
		});
		
	}
	
	@DeleteMapping("/videos/{id}")
	public ResponseEntity<?> borrarVideo(@RequestBody Videos borrar, @PathVariable Long id){
		videosRepositorio.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
