package com.gft.palmirinha.entities;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

@Entity
public class Receitas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "Nome não pode ser vazio")
    private String nome;
	
	private String unidadeEingrediente;
	
	private String tempoDePreparo;
	
	@Column(length = 2000)
	private String modoDePreparo;
	
	@ManyToMany
	@JoinTable(name = "receita_ingrediente", joinColumns = @JoinColumn(name = "receita_id"),
			inverseJoinColumns = @JoinColumn(name= "ingrediente_id"))
	Set<Ingredientes> ingredientes = new HashSet<>();

	//@ManyToMany
	//Set<ReceitaIngrediente> receitaingrediente = new HashSet<>();
	
	 @OneToMany(mappedBy = "receita")
	    private Set<ReceitaIngrediente> receitaingrediente = new HashSet<>();
	
	
	 
	 
	public String getUnidadeEingrediente() {
		return unidadeEingrediente;
	}


	public void setUnidadeEingrediente(String unidadeEingrediente) {
		this.unidadeEingrediente = unidadeEingrediente;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTempoDePrepararo() {
		return getTempoDePreparo();
	}


	public String getTempoDePreparo() {
		return tempoDePreparo;
	}

	public void setTempoDePrepararo(String tempoDePrepararo) {
		setTempoDePreparo(tempoDePrepararo);
	}


	public void setTempoDePreparo(String tempoDePrepararo) {
		this.tempoDePreparo = tempoDePrepararo;
	}

	public String getModoDePreparo() {
		return modoDePreparo;
	}

	public void setModoDePreparo(String modoDePreparo) {
		this.modoDePreparo = modoDePreparo;
	}

	public Set<Ingredientes> getIngredientes() {
		return ingredientes;
	}

	
}
