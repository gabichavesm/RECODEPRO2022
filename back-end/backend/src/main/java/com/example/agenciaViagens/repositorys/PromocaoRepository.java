package com.example.agenciaViagens.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.agenciaViagens.entities.Promocao;

@Repository
public interface PromocaoRepository extends JpaRepository<Promocao, Integer>{

}