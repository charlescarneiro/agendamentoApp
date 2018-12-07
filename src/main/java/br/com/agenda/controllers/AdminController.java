package br.com.agenda.controllers;

import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.agenda.model.Admin;
import br.com.agenda.service.AdminService;

@Controller
public class AdminController implements Serializable{
	
	@Autowired
	AdminService service;
	private Admin admin;
	public AdminController(){
		admin = new Admin();
		SecurityContext context = SecurityContextHolder.getContext();
		if(context instanceof SecurityContext)
		{
			Authentication authentication = context.getAuthentication();
			if(authentication instanceof Authentication)
			{
				 admin.setLogin(((Admin)authentication.getPrincipal()).getUsername());
			}
		}
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setUsuario(Admin admin) {
		this.admin = admin;
	}
		
	@RequestMapping("/cadastroAdmin")
	public String cadastro() {
		
		return "cadastroAdmin";
	}
	
	@PostMapping("/cadastroAdmin")
	public String salvarAdmin(@RequestParam String login, @RequestParam String senha) {
		
		Admin admin = new Admin();
		admin.setLogin(login);
		admin.setSenha(senha);
		
		service.salvarUsuario(admin);
		
		return "redirect:/";
	}
	
}