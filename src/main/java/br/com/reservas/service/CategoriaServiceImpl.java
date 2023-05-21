package br.com.reservas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.reservas.dao.CategoriaDAO;
import br.com.reservas.model.Categoria;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaDAO categoriaDAO;

	@Override
	@Transactional
	public void salvar(Categoria categoria) {
		categoriaDAO.salvar(categoria);
	}

	@Override
	@Transactional
	public List<Categoria> pesquisarCategorias() {
		return categoriaDAO.pesquisarCategorias();
	}

	@Override
	@Transactional
	public void deletar(Long idCategoria) {
		categoriaDAO.deletar(idCategoria);
	}

	@Override
	@Transactional
	public Categoria pesquisarCategoriaPorId(Long idCategoria) {
		return categoriaDAO.pesquisarCategoriaPorId(idCategoria);
	}

}