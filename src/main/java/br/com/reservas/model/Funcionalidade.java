package br.com.reservas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "funcionalidade")
public class Funcionalidade {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "home")
	private boolean home;

	@Column(name = "administracao")
	private boolean administracao;

	@Column(name = "perfil")
	private boolean perfil;

	@Column(name = "cliente")
	private boolean cliente;

	@Column(name = "funcionario")
	private boolean funcionario;

	@Column(name = "relatorio")
	private boolean relatorio;

	@Column(name = "relatorio_reservas")
	private boolean relatorioReservas;

	@Column(name = "cadastro")
	private boolean cadastro;

	@Column(name = "cadastro_categoria")
	private boolean cadastroCategoria;

	@Column(name = "cadastro_quarto")
	private boolean cadastroQuarto;

	@Column(name = "cadastro_evento")
	private boolean cadastroEvento;

	@Column(name = "cardapio")
	private boolean cardapio;

	@Column(name = "item_cadapio")
	private boolean itemCadapio;

	@Column(name = "grupo_cardapio")
	private boolean grupoCardapio;

	@Column(name = "reservas")
	private boolean reservas;

	@Column(name = "realizar_reservas")
	private boolean realizarReservas;

	@Column(name = "lista_reservas")
	private boolean listaReservas;

	@Column(name = "aceitar_reservas")
	private boolean aceitarReservas;

	@Column(name = "finalizar_reservas")
	private boolean finalizarReservas;

	@Column(name = "cancelar_reservas")
	private boolean cancelarReservas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isHome() {
		return home;
	}

	public void setHome(boolean home) {
		this.home = home;
	}

	public boolean isAdministracao() {
		return administracao;
	}

	public void setAdministracao(boolean administracao) {
		this.administracao = administracao;
	}

	public boolean isPerfil() {
		return perfil;
	}

	public void setPerfil(boolean perfil) {
		this.perfil = perfil;
	}

	public boolean isCliente() {
		return cliente;
	}

	public void setCliente(boolean cliente) {
		this.cliente = cliente;
	}

	public boolean isFuncionario() {
		return funcionario;
	}

	public void setFuncionario(boolean funcionario) {
		this.funcionario = funcionario;
	}

	public boolean isRelatorio() {
		return relatorio;
	}

	public void setRelatorio(boolean relatorio) {
		this.relatorio = relatorio;
	}

	public boolean isRelatorioReservas() {
		return relatorioReservas;
	}

	public void setRelatorioReservas(boolean relatorioReservas) {
		this.relatorioReservas = relatorioReservas;
	}

	public boolean isCadastro() {
		return cadastro;
	}

	public void setCadastro(boolean cadastro) {
		this.cadastro = cadastro;
	}

	public boolean isCadastroCategoria() {
		return cadastroCategoria;
	}

	public void setCadastroCategoria(boolean cadastroCategoria) {
		this.cadastroCategoria = cadastroCategoria;
	}

	public boolean isCadastroQuarto() {
		return cadastroQuarto;
	}

	public void setCadastroQuarto(boolean cadastroQuarto) {
		this.cadastroQuarto = cadastroQuarto;
	}

	public boolean isCadastroEvento() {
		return cadastroEvento;
	}

	public void setCadastroEvento(boolean cadastroEvento) {
		this.cadastroEvento = cadastroEvento;
	}

	public boolean isCardapio() {
		return cardapio;
	}

	public void setCardapio(boolean cardapio) {
		this.cardapio = cardapio;
	}

	public boolean isItemCadapio() {
		return itemCadapio;
	}

	public void setItemCadapio(boolean itemCadapio) {
		this.itemCadapio = itemCadapio;
	}

	public boolean isGrupoCardapio() {
		return grupoCardapio;
	}

	public void setGrupoCardapio(boolean grupoCardapio) {
		this.grupoCardapio = grupoCardapio;
	}

	public boolean isReservas() {
		return reservas;
	}

	public void setReservas(boolean reservas) {
		this.reservas = reservas;
	}

	public boolean isRealizarReservas() {
		return realizarReservas;
	}

	public void setRealizarReservas(boolean realizarReservas) {
		this.realizarReservas = realizarReservas;
	}

	public boolean isListaReservas() {
		return listaReservas;
	}

	public void setListaReservas(boolean listaReservas) {
		this.listaReservas = listaReservas;
	}

	public boolean isAceitarReservas() {
		return aceitarReservas;
	}

	public void setAceitarReservas(boolean aceitarReservas) {
		this.aceitarReservas = aceitarReservas;
	}

	public boolean isFinalizarReservas() {
		return finalizarReservas;
	}

	public void setFinalizarReservas(boolean finalizarReservas) {
		this.finalizarReservas = finalizarReservas;
	}

	public boolean isCancelarReservas() {
		return cancelarReservas;
	}

	public void setCancelarReservas(boolean cancelarReservas) {
		this.cancelarReservas = cancelarReservas;
	}

}
