package br.com.reservas.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "grupo_cardapio")
public class GrupoCardapio {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "nome")
	private String nome;

	@ManyToMany
	@JoinTable(name = "item_grupo", joinColumns = @JoinColumn(name = "id_item"), inverseJoinColumns = @JoinColumn(name = "id_grupo"))
	private List<ItemCardapio> itens = new ArrayList<>();

	@Transient
	private String sigla;

	@Transient
	private String idsItens;

	@Transient
	private String idsItensExcluir;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<ItemCardapio> getItens() {
		return itens;
	}

	public void setItens(List<ItemCardapio> itens) {
		this.itens = itens;
	}

	public String getIdsItens() {
		return idsItens;
	}

	public void setIdsItens(String idsItens) {
		this.idsItens = idsItens;
	}

	public String getIdsItensExcluir() {
		return idsItensExcluir;
	}

	public void setIdsItensExcluir(String idsItensExcluir) {
		this.idsItensExcluir = idsItensExcluir;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

}
