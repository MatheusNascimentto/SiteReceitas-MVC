package com.gft.palmirinha.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.palmirinha.entities.UnidadeMedida;
import com.gft.palmirinha.repositories.UnidadeMedidaRepository;

@Service
public class UnidadeMedidaService {
	
	@Autowired
	private UnidadeMedidaRepository unidadeMedidaRepository;
	
	public UnidadeMedida salvarUnidadeMedida(UnidadeMedida unidadeMedida) {
		return unidadeMedidaRepository.save(unidadeMedida);
	}

  public List<UnidadeMedida> listarUnidadeMedida(String nome) {
		
		if(nome!=null)
			return listarUnidadeMedidaPorNome(nome);
		
		return listarTodasUnidadesMedida();
		
	}
	
	public List<UnidadeMedida> listarTodasUnidadesMedida() {
		
		return unidadeMedidaRepository.findAll();
		
	}
	
	private List<UnidadeMedida> listarUnidadeMedidaPorNome(String nome) {
		
		return unidadeMedidaRepository.findByNomeContains(nome);
		
	}
	
	public UnidadeMedida obterUnidadeMedida(Long id) throws Exception {
		
		Optional<UnidadeMedida> unidadeMedida = unidadeMedidaRepository.findById(id);
		
		if(unidadeMedida.isEmpty()) {
			throw new Exception("Unidade de Medida não encontrada.");
		}
		
		return unidadeMedida.get();
		
	}

	public void excluirUnidadeMedida(Long id) {
		unidadeMedidaRepository.deleteById(id);
	}
	
	
}
