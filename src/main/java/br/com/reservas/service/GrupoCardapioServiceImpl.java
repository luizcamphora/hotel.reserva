package br.com.reservas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.reservas.dao.GrupoCardapioDAO;
import br.com.reservas.dao.ItemCardapioDAO;
import br.com.reservas.model.GrupoCardapio;
import br.com.reservas.model.ItemCardapio;

@Service
public class GrupoCardapioServiceImpl implements GrupoCardapioService {

	@Autowired
	private GrupoCardapioDAO grupoCardapioDAO;

	@Autowired
	private ItemCardapioDAO itemCardapioDAO;

	@Override
	@Transactional
	public void salvar(GrupoCardapio grupoCardapio) {
		
		GrupoCardapio grupoInserir = null; 
		
		if (grupoCardapio.getId() != null) {
			grupoInserir = grupoCardapioDAO.pesquisarGrupoCardapioPorId(grupoCardapio.getId());
			grupoInserir.setNome(grupoCardapio.getNome());
		}

		String idsIncluir[] = grupoCardapio.getIdsItens().split(",");
		String idsExcluir[] = grupoCardapio.getIdsItensExcluir().split(",");

		for (int i = 0; i < idsIncluir.length; i++) {
			if (!idsIncluir[i].equals("")) {
				ItemCardapio item = itemCardapioDAO.pesquisarItemCardapioPorId(Long.parseLong(idsIncluir[i]));
				grupoInserir.getItens().add(item);
			}
		}

		for (int i = 0; i < idsExcluir.length; i++) {
			if (!idsExcluir[i].equals("")) {
				ItemCardapio item = itemCardapioDAO.pesquisarItemCardapioPorId(Long.parseLong(idsExcluir[i]));
				grupoInserir.getItens().remove(item);
			}
		}

		grupoCardapioDAO.salvar(grupoInserir);
	}

	@Override
	@Transactional
	public List<GrupoCardapio> pesquisarGrupoCardapios() {
		return grupoCardapioDAO.pesquisarGrupoCardapios();
	}

	@Override
	@Transactional
	public void deletar(Long idGrupoCardapio) {
		grupoCardapioDAO.deletar(idGrupoCardapio);
	}

	@Override
	@Transactional
	public GrupoCardapio pesquisarGrupoCardapioPorId(Long idGrupoCardapio) {
		GrupoCardapio grupoCardapio = grupoCardapioDAO.pesquisarGrupoCardapioPorId(idGrupoCardapio);
		return grupoCardapio;
	}

}