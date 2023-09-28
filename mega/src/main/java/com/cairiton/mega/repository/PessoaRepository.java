package com.cairiton.mega.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cairiton.mega.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{
	
	Optional<Pessoa> findByCpf(String cpf);

}
