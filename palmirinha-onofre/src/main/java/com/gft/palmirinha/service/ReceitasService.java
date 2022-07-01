package com.gft.palmirinha.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.palmirinha.entities.Receitas;
import com.gft.palmirinha.repositories.ReceitasRepository;


@Service
public class ReceitasService {
	
	@Autowired
	private ReceitasRepository receitasRepository;
	
	public Receitas salvarReceitas(Receitas receitas) {
		
		return receitasRepository.save(receitas);
	}
	
	public List<Receitas> listarReceitas(String nome, String unidadeEingrediente) {
		
		if(nome!=null || unidadeEingrediente!=null)
			return listarReceitasPorNomeEUnidadeEIngrediente(nome, unidadeEingrediente);
		
		return listarTodasReceitas();
		
	}
	
	public List<Receitas> listarTodasReceitas() {
		
		return receitasRepository.findAll();
		
	}
	
	private List<Receitas> listarReceitasPorNomeEUnidadeEIngrediente(String nome, String unidadeEingrediente) {
		return receitasRepository.findByNomeContainsAndUnidadeEingredienteContains(nome, unidadeEingrediente);
		
	}
	
	public Receitas obterReceitas(Long id) throws Exception {
		Optional<Receitas> receitas = receitasRepository.findById(id);
		
		if(receitas.isEmpty()) {
			throw new Exception("Receitas não encontrada");
		}
		return receitas.get();
	}
	
	public void excluirReceitas(Long id) {
		receitasRepository.deleteById(id);
	}
 
}
