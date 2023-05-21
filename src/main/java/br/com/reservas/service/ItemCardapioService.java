package br.com.reservas.service;

import java.util.List;

import br.com.reservas.model.ItemCardapio;

public interface ItemCardapioService {

	public void salvar(ItemCardapio itemCardapio);

	public List<ItemCardapio> pesquisarItemCardapios();

	public void deletar(Long idItemCardapio);

	public ItemCardapio pesquisarItemCardapioPorId(Long idItemCardapio);

}