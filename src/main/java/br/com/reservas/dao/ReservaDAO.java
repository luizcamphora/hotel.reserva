package br.com.reservas.dao;

import java.time.LocalDateTime;
import java.util.List;

import br.com.reservas.model.Reserva;
import br.com.reservas.model.StatusReserva;
import br.com.reservas.model.Usuario;

public interface ReservaDAO {

	public void salvar(Reserva reserva);

	public List<Reserva> pesquisarReservas();

	public void deletar(Long idReserva);

	public Reserva pesquisarReservaPorId(Long idReserva);

	public List<Reserva> pesquisarReservasPorUsuarioLogado(Usuario usuario);

	public List<Reserva> pesquisarReservasStatus(StatusReserva status);

	public List<Reserva> pesquisarReservaPorIntervaloDatas(LocalDateTime dataInico, LocalDateTime dataFim);

	public List<Reserva> pesquisarReservasUsuarioStatus(Usuario usuario, StatusReserva status);

}
