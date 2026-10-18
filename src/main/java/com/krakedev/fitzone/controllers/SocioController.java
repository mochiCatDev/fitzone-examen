package com.krakedev.fitzone.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.fitzone.entidades.Socio;
import com.krakedev.fitzone.services.ServicioSocio;

@RestController
@RequestMapping("/socios")
public class SocioController {
	private final ServicioSocio servicioSocio;

	public SocioController(ServicioSocio servicioSocio) {
		super();
		this.servicioSocio = servicioSocio;
	}

	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Socio socio) {
		try {
			Socio nuevoSocio = servicioSocio.crear(socio);
			return ResponseEntity.status(HttpStatus.CREATED).body(nuevoSocio);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear el socio");
		}
	}

	@GetMapping
	public ResponseEntity<?> listar() {
		try {
			List<Socio> socios = servicioSocio.listar();
			return ResponseEntity.ok(socios);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al listar los socios");
		}
	}

	@GetMapping("/estado")
	public ResponseEntity<?> buscarPorEstado(@RequestParam boolean activo) {
		try {
			List<Socio> socios = servicioSocio.buscarPorEstado(activo);
			return ResponseEntity.ok(socios);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al buscar socios por estado");
		}
	}
}