package br.com.reservas.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.reservas.utils.DataUtils;
import br.com.reservas.utils.LocalDateTimeConverter;

@Entity
@Table(name = "evento")
public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "descricao")
	private String descricao;

	@Column(name = "data_evento")
	@Convert(converter = LocalDateTimeConverter.class)
	private LocalDateTime dataHoraEvento;

	@Column(name = "path_imagem")
	private String pathImagem;

	@Transient
	private String dataEventoStr;

	@Transient
	private String horarioEventoStr;

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDateTime getDataHoraEvento() {
		return dataHoraEvento;
	}

	public void setDataHoraEvento(LocalDateTime dataHoraEvento) {
		this.dataHoraEvento = dataHoraEvento;
	}

	public String getDataEventoStr() {
		if (dataHoraEvento == null)
			return dataEventoStr;
		else
			return DataUtils.converterLocalDateTimeParaStringDate(dataHoraEvento);
	}

	public void setDataEventoStr(String dataEventoStr) {
		this.dataEventoStr = dataEventoStr;
	}

	public String getHorarioEventoStr() {
		return horarioEventoStr;
	}

	public void setHorarioEventoStr(String horarioEventoStr) {
		this.horarioEventoStr = horarioEventoStr;
	}

	public String getPathImagem() {
		return pathImagem;
	}

	public void setPathImagem(String pathImagem) {
		this.pathImagem = pathImagem;
	}

}
