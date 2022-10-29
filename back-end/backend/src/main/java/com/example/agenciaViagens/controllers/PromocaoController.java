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
import com.example.agenciaViagens.entities.Promocao;
import com.example.agenciaViagens.repositorys.DestinoRepository;
import com.example.agenciaViagens.repositorys.PromocaoRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")

public class PromocaoController {

	
	
	@Autowired
	private PromocaoRepository promocaoRepository;
	
	
	@Autowired
	private DestinoRepository destinoRepository;
	
	
	
	
	@GetMapping("/promocoes")
	public List<Promocao> getAllPromocoes(){
		return promocaoRepository.findAll();
	}
	
	
	
	
	@GetMapping("/promocoes/{id}")
	public ResponseEntity<Promocao> getPromocaoById(@PathVariable int id) {
		Promocao promocao = promocaoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Promoção inexistente"));
		 return ResponseEntity.ok(promocao);
	}
	
	
	
	
	@PostMapping("/promocoes")
	public Promocao createPromocao(@RequestBody Promocao promocao) {
		return promocaoRepository.save(promocao);
	}
	
	
	
	
	@PutMapping("promocoes/{id}")
	public ResponseEntity<Promocao> updatePromocao(@PathVariable int id, @RequestBody Promocao promocoesDetails){
		
		Promocao promocao = promocaoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Promoção Inexistente"));
		Destino destino = destinoRepository.findById(promocoesDetails.getDestino().getId()).get();
		
		promocao.setNome(promocoesDetails.getNome());
		promocao.setValorPromo(promocoesDetails.getValorPromon());
		promocao.setDestino(destino);
		
		
	    Promocao newPromocao = promocaoRepository.save(promocao);
		
		return ResponseEntity.ok(newPromocao); 
		}
	
	
	
	
	
	//DELETE
	@DeleteMapping("/promocoes/{id}")
	public ResponseEntity<Map<String, Boolean>> deletePromocao(@PathVariable int id){
		
		Promocao promocao = promocaoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Promoção Inexistente"));
		
		promocaoRepository.delete(promocao);
		Map<String, Boolean> response = new HashMap<>();
		response.put("é isso! deletado", Boolean.TRUE);
		return ResponseEntity.ok(response);
	
	
	
	}
	
}