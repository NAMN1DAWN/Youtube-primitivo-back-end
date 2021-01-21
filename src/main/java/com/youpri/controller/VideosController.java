package com.youpri.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.youpri.modelo.Categoria;
import com.youpri.modelo.CategoriaRepositorio;
import com.youpri.modelo.Videos;
import com.youpri.modelo.VideosRepositorio;
import com.youpri.rest.dto.CreateVideos;
import com.youpri.rest.dto.VideosDTO;
import com.youpri.rest.dto.converter.VideosDTOConverter;
import com.youpri.rest.service.VideosService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class VideosController {

	private final VideosRepositorio videosRepositorio = null;
	private final VideosDTOConverter videosDTOConverter = null;
	private final CategoriaRepositorio categoriaRepositorio = null;
	
	@GetMapping("/videos")
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
	
	@GetMapping("/videos/{id}")
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
	
	@PostMapping("/videos")
	public ResponseEntity<VideosDTO> nuevoVideo(@RequestBody CreateVideos nuevo){
		//Videos nuevosVideos = new Videos();
		//nuevosVideos.setTitulo(nuevo.getTitulo());
		//nuevosVideos.setDescripcion(nuevo.getDescripcion());
		//Categoria categoria = categoriaRepositorio.findById(nuevo.getCategoriaId()).orElseGet(null);
		//nuevosVideos.setCategoria(categoria);
		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(VideosService.crearVideos(nuevo));
	}
	
	@PutMapping("/videos/{id}")
	public ResponseEntity<?> editarVideo(@RequestBody Videos editar, @PathVariable Long id){
		return videosRepositorio.findById(id).map(v -> {
			v.setTitulo(editar.getTitulo());
			v.setDescripcion(editar.getDescripcion());
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
