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

import com.gft.palmirinha.entities.Ingredientes;
import com.gft.palmirinha.service.IngredientesService;

@Controller
@RequestMapping("ingredientes")
public class IngredientesController {
	
	@Autowired
	private IngredientesService ingredientesService;
	
	@RequestMapping(path = "novo")
	public ModelAndView novoIngredientes() {
		
		ModelAndView mv = new ModelAndView("ingredientes/novo.html");
		mv.addObject("ingredientes", new Ingredientes());
		
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST , path = "novo")
	public ModelAndView salvarIngredientes(@Valid Ingredientes ingredientes, BindingResult bindingResult) {
		
		ModelAndView mv = new ModelAndView("ingredientes/novo.html");
		
		boolean novo = true;
		
		if(ingredientes.getId() != null) {
			novo = false;
		}
		
		if(bindingResult.hasErrors()) {
			mv.addObject("ingredientes", ingredientes);
			return mv;
		}
	
		ingredientesService.salvarIngredientes(ingredientes);
		
		if(novo) {
			mv.addObject("ingredientes", new Ingredientes());
		}else {
			mv.addObject("ingredientes", ingredientes);
		}
		
 		mv.addObject("ingredientes", new Ingredientes());
		
	  
	  
	  mv.addObject("mensagem", "Ingredientes salvo com sucesso");
		
		return mv;
	}

	@RequestMapping(path = "listar")
	public ModelAndView listarIngredientes(String nome) {
		
		ModelAndView mv = new ModelAndView("ingredientes/listar.html");
		mv.addObject("lista", ingredientesService.listarIngredientes(nome));
		
		return mv;
		
	}
	
	@RequestMapping("/editar")
     public ModelAndView editarIngredientes(@RequestParam Long id) {
		
		ModelAndView mv = new ModelAndView("ingredientes/novo.html");
		
		Ingredientes ingredientes;
		
		try {
			ingredientes = ingredientesService.obterIngredientes(id);
		}catch(Exception e) {
			ingredientes= new Ingredientes();
			mv.addObject("mensagem", e.getMessage());
			
		}

		mv.addObject("ingredientes", ingredientes);
		
		return mv;		
				
	}
	
	@RequestMapping("/excluir")
    public ModelAndView excluirIngredientes(@RequestParam Long id, RedirectAttributes redirectAttributes) {
		
		ModelAndView mv = new ModelAndView("redirect:/ingredientes/listar");
		
		try {
		  ingredientesService.excluirIngredientes(id);
		  redirectAttributes.addFlashAttribute("mensagem", "Ingrediente excluido com sucesso");
		}catch(Exception e) {
			 redirectAttributes.addFlashAttribute("mensagem", "Erro ao excluir Ingrediente"+e.getMessage());
			
		}

		return mv;		
				
	}

}
