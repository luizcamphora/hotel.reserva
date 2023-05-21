package br.com.reservas.service;

import java.time.LocalDateTime;
import java.util.List;

import br.com.reservas.model.Reserva;
import br.com.reservas.model.StatusReserva;
import br.com.reservas.model.Usuario;

public interface ReservaService {

	public void salvar(Reserva reserva);

	public List<Reserva> pesquisarReservas();

	public void deletar(Long idReserva);

	public Reserva pesquisarReservaPorId(Long idReserva);

	public List<Reserva> pesquisarReservasStatus(StatusReserva status);

	public List<Reserva> pesquisarReservasPorUsuarioLogado(Usuario usuario);

	public void ativarReserva(Long id);

	public void finalizarReserva(Long id);

	public void cancelarReserva(Long id, Usuario usuario);

	public List<Reserva> pesquisarReservaPorIntervaloDatas(LocalDateTime dataInico, LocalDateTime dataFim);

	List<Reserva> pesquisarReservasUsuarioStatus(Usuario usuario, StatusReserva status);

}