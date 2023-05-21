package br.com.reservas.service;

import java.util.List;

import br.com.reservas.model.Evento;

public interface EventoService {

	public void salvar(Evento evento);

	public List<Evento> pesquisarEventos();

	public void deletar(Long idEvento);

	public Evento pesquisarEventoPorId(Long idEvento);

}