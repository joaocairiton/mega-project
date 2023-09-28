package com.cairiton.mega.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cairiton.mega.model.Bairro;

public interface BairroRepository extends JpaRepository<Bairro, Integer> {
	
	List<Bairro> findByNome(String nome);
	
	List<Bairro> findByNomeContaining(String nome);

}
