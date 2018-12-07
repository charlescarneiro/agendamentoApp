package br.com.agenda.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.agenda.model.Agendamento;
import br.com.agenda.repository.AgendamentoRepository;

@Controller
public class CadastroController {

	@Autowired
	private AgendamentoRepository repository;
	
	@RequestMapping(value="/cadastro", method = RequestMethod.GET)
	public String form(){
		return "cadastro";
	}
	
	@RequestMapping(value="/cadastro", method = RequestMethod.POST)
	public String cadastrar(@Valid Agendamento agendamento, BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()){
			attributes.addFlashAttribute("mensagem", "Verifique os campos digitados!");
			return form();
		}
		repository.save(agendamento);
		System.out.print(agendamento.getData());
		System.out.print(agendamento.getNomeCliente());
		attributes.addFlashAttribute("mensagem", "Procedimento agendado com sucesso!");
		return "redirect:/";
	}
}
