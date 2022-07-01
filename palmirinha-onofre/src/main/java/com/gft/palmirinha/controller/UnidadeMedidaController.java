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
import com.gft.palmirinha.entities.UnidadeMedida;
import com.gft.palmirinha.service.UnidadeMedidaService;

@Controller
@RequestMapping("unidadeMedida")
public class UnidadeMedidaController {

	@Autowired
	private UnidadeMedidaService unidadeMedidaService;
	
	@RequestMapping(path = "novo")
	public ModelAndView novaUnidadeMedida() {
		
		ModelAndView mv = new ModelAndView("unidadeMedida/novo.html");
		mv.addObject("unidadeMedida", new UnidadeMedida());
		
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST , path = "novo")
	public ModelAndView salvarUnidadeMedida(@Valid UnidadeMedida unidadeMedida, BindingResult bindingResult) {
		
		ModelAndView mv = new ModelAndView("unidadeMedida/novo.html");
		
           boolean novo = true;
		
		if(unidadeMedida.getId() != null) {
			novo = false;
		}
		
		
		if(bindingResult.hasErrors()) {
			mv.addObject("unidadeMedida", unidadeMedida);
			return mv;
		}
	
		unidadeMedidaService.salvarUnidadeMedida(unidadeMedida);
		
		if(novo) {
			mv.addObject("unidadeMedida", new UnidadeMedida());
		}else {
			mv.addObject("unidadeMedida", unidadeMedida);
		}
		
 		mv.addObject("unidadeMedida", new UnidadeMedida());
		
	  
	  
	  mv.addObject("mensagem", "Unidade Medida salva com sucesso");
		
		return mv;
	}

	@RequestMapping(path = "listar")
	public ModelAndView listarUnidadeMedida(String nome) {
		
		ModelAndView mv = new ModelAndView("unidadeMedida/listar.html");
		mv.addObject("lista", unidadeMedidaService.listarUnidadeMedida(nome));
		
		return mv;
		
	}
	
	@RequestMapping("/editar")
     public ModelAndView editarUnidadeMedida(@RequestParam Long id) {
		
		ModelAndView mv = new ModelAndView("unidadeMedida/novo.html");
		UnidadeMedida unidadeMedida;
		
		try {
			unidadeMedida = unidadeMedidaService.obterUnidadeMedida(id);
		}catch(Exception e) {
			unidadeMedida = new UnidadeMedida();
			mv.addObject("mensagem", e.getMessage());
			
		}

		mv.addObject("unidadeMedida", unidadeMedida);
		
		return mv;		
				
	}
	
	@RequestMapping("/excluir")
    public ModelAndView excluirUnidadeMedida(@RequestParam Long id, RedirectAttributes redirectAttributes) {
		
		ModelAndView mv = new ModelAndView("redirect:/unidadeMedida");
		
		try {
		 unidadeMedidaService.excluirUnidadeMedida(id);
		  redirectAttributes.addFlashAttribute("mensagem", "Unidade de Medida  excluida com sucesso");
		}catch(Exception e) {
			 redirectAttributes.addFlashAttribute("mensagem", "Erro ao excluir Unidade de Medida"+e.getMessage());
			
		}

		return mv;		
				
	}
	
}
