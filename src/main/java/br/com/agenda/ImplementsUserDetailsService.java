package br.com.agenda;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.com.agenda.model.Admin;
import br.com.agenda.repository.AdminRepository;


@Repository
@Transactional
public class ImplementsUserDetailsService implements UserDetailsService{
	
	@Autowired
	private AdminRepository admRepo;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Admin user = admRepo.findByLogin(login);
		
		if(user == null)
			throw new UsernameNotFoundException("Usuário não encontrado");
		return new User(user.getLogin(), user.getSenha(), true, true, true, true, user.getAuthorities());
	}

}