package br.com.reservas.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.reservas.utils.DataUtils;
import br.com.reservas.utils.LocalDateTimeConverter;

@Entity
@Table(name = "reserva")
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "codigo")
	private String codigo;

	@ManyToOne
	@JoinColumn(name = "id_usuario", referencedColumnName = "id")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "id_quarto", referencedColumnName = "id")
	private Quarto quarto;

	@Column(name = "data_reserva")
	@Convert(converter = LocalDateTimeConverter.class)
	private LocalDateTime dataReserva;

	@Column(name = "data_check_in")
	@Convert(converter = LocalDateTimeConverter.class)
	private LocalDateTime dataCheckIn;

	@Transient
	private String dataCheckInStr;

	@Column(name = "data_check_out")
	@Convert(converter = LocalDateTimeConverter.class)
	private LocalDateTime dataCheckOut;

	@Transient
	private String dataCheckOutStr;

	@Column(name = "qtd_adultos")
	private int qtdAdultos;

	@Column(name = "qtd_criancas")
	private int qtdCriancas;

	@Column(name = "nome_hospedes")
	private String nomeHospedes;

	@Column(name = "status")
	private StatusReserva status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}

	public LocalDateTime getDataReserva() {
		return dataReserva;
	}

	public void setDataReserva(LocalDateTime dataReserva) {
		this.dataReserva = dataReserva;
	}

	public LocalDateTime getDataCheckIn() {
		return dataCheckIn;
	}

	public void setDataCheckIn(LocalDateTime dataCheckIn) {
		this.dataCheckIn = dataCheckIn;
	}

	public LocalDateTime getDataCheckOut() {
		return dataCheckOut;
	}

	public void setDataCheckOut(LocalDateTime dataCheckOut) {
		this.dataCheckOut = dataCheckOut;
	}

	public int getQtdAdultos() {
		return qtdAdultos;
	}

	public void setQtdAdultos(int qtdAdultos) {
		this.qtdAdultos = qtdAdultos;
	}

	public int getQtdCriancas() {
		return qtdCriancas;
	}

	public void setQtdCriancas(int qtdCriancas) {
		this.qtdCriancas = qtdCriancas;
	}

	public String getNomeHospedes() {
		return nomeHospedes;
	}

	public void setNomeHospedes(String nomeHospedes) {
		this.nomeHospedes = nomeHospedes;
	}

	public StatusReserva getStatus() {
		return status;
	}

	public void setStatus(StatusReserva status) {
		this.status = status;
	}

	public String getDataCheckInStr() {
		if (dataCheckIn == null)
			return dataCheckInStr;
		else
			return DataUtils.converterLocalDateTimeParaStringDate(dataCheckIn);
	}

	public void setDataCheckInStr(String dataCheckInStr) {
		this.dataCheckInStr = dataCheckInStr;
	}

	public String getDataCheckOutStr() {
		if (dataCheckOut == null)
			return dataCheckOutStr;
		else
			return DataUtils.converterLocalDateTimeParaStringDate(dataCheckOut);
	}

	public void setDataCheckOutStr(String dataCheckOutStr) {
		this.dataCheckOutStr = dataCheckOutStr;
	}

}
