package br.com.reservas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.reservas.dao.ItemCardapioDAO;
import br.com.reservas.model.ItemCardapio;
import br.com.reservas.utils.MoneyUtils;

@Service
public class ItemCardapioServiceImpl implements ItemCardapioService {

	@Autowired
	private ItemCardapioDAO itemCardapioDAO;

	@Override
	@Transactional
	public void salvar(ItemCardapio itemCardapio) {
		itemCardapio.setPreco(MoneyUtils.formatarValor(itemCardapio.getPrecoStr()));
		itemCardapioDAO.salvar(itemCardapio);
	}

	@Override
	@Transactional
	public List<ItemCardapio> pesquisarItemCardapios() {
		return itemCardapioDAO.pesquisarItemCardapios();
	}

	@Override
	@Transactional
	public void deletar(Long idItemCardapio) {
		itemCardapioDAO.deletar(idItemCardapio);
	}

	@Override
	@Transactional
	public ItemCardapio pesquisarItemCardapioPorId(Long idItemCardapio) {
		ItemCardapio itemCardapio = itemCardapioDAO.pesquisarItemCardapioPorId(idItemCardapio);
		itemCardapio.setPrecoStr(MoneyUtils.formatarValor(itemCardapio.getPreco()));
		return itemCardapio;
	}

}