package br.com.agenda.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.agenda.model.Agendamento;
import br.com.agenda.repository.AgendamentoRepository;


@Controller
public class HomeController {

	@Autowired
	private AgendamentoRepository repository;
	
	@RequestMapping("/")
	public String index(Model model){
		Iterable<Agendamento> agendamentos = repository.findAll();
		model.addAttribute("agendamentos", agendamentos);
		System.out.print(agendamentos);
		return "index";
	}
	
	@RequestMapping(value= "/{nomeCliente}", method = RequestMethod.GET)
	public ModelAndView detalhes(@PathVariable("nomeCliente") String nomeCliente){
		ModelAndView modelAndView = new ModelAndView("agendamento");
		Agendamento agendamentos = repository.findOne(nomeCliente);
		modelAndView.addObject("agendamentos",agendamentos);
		return modelAndView;
	}
	
	@RequestMapping("/delete")
	public String delete(String nomeCliente){
		repository.delete(nomeCliente);
		return "redirect:/";
	}
}
