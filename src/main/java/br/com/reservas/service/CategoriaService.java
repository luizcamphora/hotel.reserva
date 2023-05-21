package br.com.reservas.service;

import java.util.List;

import br.com.reservas.model.Categoria;

public interface CategoriaService {

	public void salvar(Categoria categoria);

	public List<Categoria> pesquisarCategorias();

	public void deletar(Long idCategoria);

	public Categoria pesquisarCategoriaPorId(Long idCategoria);

}