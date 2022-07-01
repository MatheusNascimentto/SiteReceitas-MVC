package com.gft.palmirinha.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ReceitaIngredienteId implements Serializable {
	
	private Long receitaid;
	
	private Long ingredienteid;
	

	public Long getReceitaid() {
		return receitaid;
	}

	public void setReceitaid(Long receitaid) {
		this.receitaid = receitaid;
	}

	public Long getIngredienteid() {
		return ingredienteid;
	}

	public void setIngredienteid(Long ingredienteid) {
		this.ingredienteid = ingredienteid;
	}


}
