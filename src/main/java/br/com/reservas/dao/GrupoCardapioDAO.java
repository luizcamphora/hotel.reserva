package br.com.reservas.dao;

import java.util.List;

import br.com.reservas.model.GrupoCardapio;

public interface GrupoCardapioDAO {

	public void salvar(GrupoCardapio grupoCardapio);

	public List<GrupoCardapio> pesquisarGrupoCardapios();

	public void deletar(Long idGrupoCardapio);

	public GrupoCardapio pesquisarGrupoCardapioPorId(Long idGrupoCardapio);

}
