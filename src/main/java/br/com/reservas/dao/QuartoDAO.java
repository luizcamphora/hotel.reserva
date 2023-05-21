package br.com.reservas.dao;

import java.util.List;

import br.com.reservas.model.Quarto;

public interface QuartoDAO {

	public void salvar(Quarto quarto);

	public List<Quarto> pesquisarQuartos();

	public void deletar(Long idQuarto);

	public Quarto pesquisarQuartoPorId(Long idQuarto);

}
