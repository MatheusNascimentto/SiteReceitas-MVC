package com.gft.palmirinha.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity 
@Table(name = "receita_ingrediente")
public class ReceitaIngrediente {
	
	@EmbeddedId
	private ReceitaIngredienteId id = new ReceitaIngredienteId();

    @ManyToOne
    @MapsId("receitaid")
	private Receitas receita;
	
    @ManyToOne
    @MapsId("ingredienteid")
	private Ingredientes ingrediente;
    
    
    private Long quantidade;
    
  

	public ReceitaIngredienteId getId() {
		return id;
	}

	public void setId(ReceitaIngredienteId id) {
		this.id = id;
	}

	public Receitas getReceita() {
		return receita;
	}

	public void setReceita(Receitas receita) {
		this.receita = receita;
	}

	public Ingredientes getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(Ingredientes ingrediente) {
		this.ingrediente = ingrediente;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}
    
    
}
