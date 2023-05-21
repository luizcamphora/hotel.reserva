package br.com.reservas.service;

import java.util.List;

import br.com.reservas.model.GrupoCardapio;

public interface GrupoCardapioService {

	public void salvar(GrupoCardapio grupoCardapio);

	public List<GrupoCardapio> pesquisarGrupoCardapios();

	public void deletar(Long idGrupoCardapio);

	public GrupoCardapio pesquisarGrupoCardapioPorId(Long idGrupoCardapio);

}