package br.com.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.agenda.model.Admin;


@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{
	Admin findByLogin(String login);


}
