package com.gft.palmirinha.entities;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Ingredientes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	 @OneToMany(mappedBy = "receita")
	    private Set<ReceitaIngrediente> receitaingrediente = new HashSet<>();


	public Ingredientes(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	

	public Ingredientes() {
		super();
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}



	@Override
	public String toString() {
		return nome;
	}
	
	

	
}
