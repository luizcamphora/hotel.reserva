package br.com.reservas.service;

import java.util.List;

import br.com.reservas.model.Quarto;

public interface QuartoService {

	public void salvar(Quarto quarto);

	public List<Quarto> pesquisarQuartos();

	public void deletar(Long idQuarto);

	public Quarto pesquisarQuartoPorId(Long idQuarto);

}