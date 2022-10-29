package com.example.agenciaViagens.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.agenciaViagens.ResourceNotFoundException;
import com.example.agenciaViagens.entities.Destino;
import com.example.agenciaViagens.repositorys.DestinoRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")

		public class DestinoController {

			
			
			
			@Autowired
			private DestinoRepository destinoRepository;
			
			
			
			//READ ou GET all
			@GetMapping("/destinos")
			public List<Destino> getAllDestinos(){
				return destinoRepository.findAll();
			}
			
			
			
			
			//READ ou GET by id
			@GetMapping("/destinos/{id}")
			public ResponseEntity<Destino> getDestinoById(@PathVariable int id) {
				Destino destino = destinoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Destino inexistente"));
				 return ResponseEntity.ok(destino);
			}
			
			
			
			
			
			//POST ou CREATE
			@PostMapping("/destinos")
			public Destino createDestino(@RequestBody Destino destino) {
				return destinoRepository.save(destino);
			}
			
			
			
			

			
			
			//PUT ou UPDATE
			@PutMapping("destinos/{id}")
			public ResponseEntity<Destino> updateDestino(@PathVariable int id, @RequestBody Destino destinosDetails){
				
				Destino destino = destinoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Destino Inexistente"));
				
				destino.setNome(destinosDetails.getNome());
				destino.setEstado(destinosDetails.getEstado());
				destino.setPais(destinosDetails.getPais());
				destino.setDataIda(destinosDetails.getDataIda());
				destino.setDataVolta(destinosDetails.getDataVolta());
				destino.setValor(destinosDetails.getValor());
				
				Destino newDestino = destinoRepository.save(destino);
				
				return ResponseEntity.ok(newDestino);
			}
			
			
			
			//DELETE
			@DeleteMapping("/destinos/{id}")
			public ResponseEntity<Map<String, Boolean>> deleteDestino(@PathVariable int id){
				
				Destino destino = destinoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Destino Inexistente"));
				
				destinoRepository.delete(destino);
				Map<String, Boolean> response = new HashMap<>();
				response.put("deleted", Boolean.TRUE);
				return ResponseEntity.ok(response);
				
				
			}
			
			
			
			
			
			
		}