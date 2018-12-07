package br.com.agenda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import br.com.agenda.model.Admin;
import br.com.agenda.repository.AdminRepository;


@Service
public class AdminService {
	
	@Autowired
	AdminRepository repo;
	
	public Admin salvarUsuario(Admin user) {
		
		user.setSenha(new BCryptPasswordEncoder().encode(user.getSenha()));
		repo.save(user);
		return user;
	}
	
	public List<Admin> getUsuarios(){
		
		return repo.findAll();
	}
}