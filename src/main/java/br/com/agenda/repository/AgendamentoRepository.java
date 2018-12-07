package br.com.agenda.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.agenda.model.Agendamento;


public interface AgendamentoRepository extends CrudRepository<Agendamento, String>{

}
