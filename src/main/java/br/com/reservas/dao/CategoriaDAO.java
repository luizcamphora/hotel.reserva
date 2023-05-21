package br.com.reservas.dao;

import java.util.List;

import br.com.reservas.model.Categoria;

public interface CategoriaDAO {

	public void salvar(Categoria categoria);

	public List<Categoria> pesquisarCategorias();

	public void deletar(Long idCategoria);

	public Categoria pesquisarCategoriaPorId(Long idCategoria);

}
