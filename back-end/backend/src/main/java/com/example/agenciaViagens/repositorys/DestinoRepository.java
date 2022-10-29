package com.example.agenciaViagens.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.agenciaViagens.entities.Destino;

@Repository
public interface DestinoRepository extends JpaRepository<Destino, Integer>{

}