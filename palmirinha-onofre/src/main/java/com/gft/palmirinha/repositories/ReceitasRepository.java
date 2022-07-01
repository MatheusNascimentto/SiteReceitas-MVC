package com.gft.palmirinha.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.palmirinha.entities.Receitas;

@Repository
public interface ReceitasRepository extends JpaRepository<Receitas, Long> {

	List<Receitas> findByNomeContains(String nome);
	
	List<Receitas> findByNomeContainsAndUnidadeEingredienteContains(String nome, String unidadeEingrediente);
	
}
