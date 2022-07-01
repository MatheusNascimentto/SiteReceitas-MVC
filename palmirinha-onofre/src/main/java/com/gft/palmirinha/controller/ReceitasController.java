package com.gft.palmirinha.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gft.palmirinha.entities.Receitas;
import com.gft.palmirinha.service.IngredientesService;
import com.gft.palmirinha.service.ReceitasService;
import com.gft.palmirinha.service.UnidadeMedidaService;



@Controller
@RequestMapping("receitas")
public class ReceitasController {
	
	@Autowired
	private ReceitasService receitasService;
	
	@Autowired
	private IngredientesService ingredientesService;
	
	@Autowired
	private UnidadeMedidaService unidadeMedidaService;
	
	
	@RequestMapping(path = "editar")
	public ModelAndView editarReceitas(@RequestParam(required = false) Long id) {
		
		ModelAndView mv = new ModelAndView("receitas/novo.html");
		
		Receitas receitas;
		
		if(id==null) {
			receitas = new Receitas();
		}else {
			try {
				receitas = receitasService.obterReceitas(id);
			}catch(Exception e) {
				receitas = new Receitas();
				mv.addObject("mensagem", e.getMessage());
			}
		}
		mv.addObject("receitas", receitas);
		mv.addObject("listarIngredientes", ingredientesService.listarIngredientes(null));
		mv.addObject("listarUnidadeMedida", unidadeMedidaService.listarUnidadeMedida(null));
		
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST , path = "editar")
	public ModelAndView salvarReceitas(@Valid Receitas receitas, BindingResult bindingResult) {
		
	ModelAndView mv = new ModelAndView("receitas/novo.html");
	
	boolean novo = true;
	
	if(receitas.getId() != null) {
		novo = false;
	}
	
	    if(bindingResult.hasErrors()) {
	     	mv.addObject("receitas", receitas);
		    return mv;
	     }
	    
	   receitasService.salvarReceitas(receitas);
	    
	    if(novo) {
	    	mv.addObject("receitas", new Receitas());
	    }else {
	    	mv.addObject("receitas", receitas);
	    }
	    
	    mv.addObject("mensagem", "Receita salva com sucesso");
	    mv.addObject("listarIngredientes", ingredientesService.listarIngredientes(null));
	    mv.addObject("listarUnidadeMedida", unidadeMedidaService.listarUnidadeMedida(null));
	    
		return mv;
		
	}
	
	@RequestMapping
	public ModelAndView listarReceitas(String nome,String unidadeEingrediente) {
		
		ModelAndView mv = new ModelAndView("receitas/listar.html");
		
		
		mv.addObject("lista", receitasService.listarReceitas(nome, unidadeEingrediente));
		
		mv.addObject("nome", nome);
		mv.addObject("unidadeEingrediente", unidadeEingrediente);
		
		
		return mv;
		
	}
	
	
	@RequestMapping("/excluir")
    public ModelAndView excluirReceitas(@RequestParam Long id, RedirectAttributes redirectAttributes) {
		
		ModelAndView mv = new ModelAndView("redirect:/receitas");
		
		try {
		  receitasService.excluirReceitas(id);
		  redirectAttributes.addFlashAttribute("mensagem", "Receita excluida com sucesso");
		}catch(Exception e) {
			 redirectAttributes.addFlashAttribute("mensagem", "Erro ao excluir Receita"+e.getMessage());
			
		}

		return mv;		
				
	}
	
}
