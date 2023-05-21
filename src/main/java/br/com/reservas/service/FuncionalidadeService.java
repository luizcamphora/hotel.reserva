package br.com.reservas.service;

import java.util.List;

import br.com.reservas.model.Funcionalidade;

public interface FuncionalidadeService {

	public void salvar(Funcionalidade funcionalidade);

	public List<Funcionalidade> pesquisarFuncionalidades();

	public void deletar(Long idFuncionalidade);

	public Funcionalidade pesquisarFuncionalidadePorId(Long idFuncionalidade);

}