package br.com.reservas.dao;

import java.util.List;

import br.com.reservas.model.Evento;

public interface EventoDAO {

	public void salvar(Evento evento);

	public List<Evento> pesquisarEventos();

	public void deletar(Long idEvento);

	public Evento pesquisarEventoPorId(Long idEvento);

}
