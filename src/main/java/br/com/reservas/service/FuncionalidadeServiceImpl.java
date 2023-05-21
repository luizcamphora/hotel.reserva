package br.com.reservas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.reservas.dao.FuncionalidadeDAO;
import br.com.reservas.model.Funcionalidade;

@Service
public class FuncionalidadeServiceImpl implements FuncionalidadeService {

	@Autowired
	private FuncionalidadeDAO funcionalidadeDAO;

	@Override
	@Transactional
	public void salvar(Funcionalidade funcionalidade) {
		funcionalidadeDAO.salvar(funcionalidade);
	}

	@Override
	@Transactional
	public List<Funcionalidade> pesquisarFuncionalidades() {
		return funcionalidadeDAO.pesquisarFuncionalidades();
	}

	@Override
	@Transactional
	public void deletar(Long idFuncionalidade) {
		funcionalidadeDAO.deletar(idFuncionalidade);
	}

	@Override
	@Transactional
	public Funcionalidade pesquisarFuncionalidadePorId(Long idFuncionalidade) {
		return funcionalidadeDAO.pesquisarFuncionalidadePorId(idFuncionalidade);
	}

}