package br.com.reservas.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.reservas.dao.ReservaDAO;
import br.com.reservas.model.Cliente;
import br.com.reservas.model.Reserva;
import br.com.reservas.model.StatusReserva;
import br.com.reservas.model.Usuario;
import br.com.reservas.utils.DataUtils;

@Service
public class ReservaServiceImpl implements ReservaService {

	@Autowired
	private ReservaDAO reservaDAO;

	@Override
	@Transactional
	public void salvar(Reserva reserva) {

		reserva.setDataReserva(LocalDateTime.now());
		reserva.setStatus(StatusReserva.RESERVA_REALIZADA);
		reserva.setDataCheckIn(DataUtils.converterStringParaLocalDateTime(reserva.getDataCheckInStr() + " 00:00"));
		reserva.setDataCheckOut(DataUtils.converterStringParaLocalDateTime(reserva.getDataCheckOutStr() + " 00:00"));
		reserva.setCodigo(getCodigoReserva());

		reservaDAO.salvar(reserva);
	}

	private String getCodigoReserva() {
		return "R" + (reservaDAO.pesquisarReservas().size() + 1);
	}

	@Override
	@Transactional
	public List<Reserva> pesquisarReservas() {
		return reservaDAO.pesquisarReservas();
	}

	@Override
	@Transactional
	public void deletar(Long idReserva) {
		reservaDAO.deletar(idReserva);
	}

	@Override
	@Transactional
	public Reserva pesquisarReservaPorId(Long idReserva) {
		return reservaDAO.pesquisarReservaPorId(idReserva);
	}

	@Override
	@Transactional
	public List<Reserva> pesquisarReservasPorUsuarioLogado(Usuario usuario) {
		return reservaDAO.pesquisarReservasPorUsuarioLogado(usuario);
	}

	@Override
	@Transactional
	public List<Reserva> pesquisarReservasStatus(StatusReserva status) {
		return reservaDAO.pesquisarReservasStatus(status);
	}

	@Override
	@Transactional
	public List<Reserva> pesquisarReservasUsuarioStatus(Usuario usuario, StatusReserva status) {
		return reservaDAO.pesquisarReservasUsuarioStatus(usuario, status);
	}

	@Override
	@Transactional
	public void ativarReserva(Long id) {
		Reserva reserva = reservaDAO.pesquisarReservaPorId(id);
		reserva.setStatus(StatusReserva.RESERVA_ATIVA);
		reservaDAO.salvar(reserva);
		
	}
	
	@Override
	@Transactional
	public void finalizarReserva(Long id) {
		Reserva reserva = reservaDAO.pesquisarReservaPorId(id);
		reserva.setStatus(StatusReserva.RESERVA_FINALIZADA);
		reservaDAO.salvar(reserva);
		
	}
	
	@Override
	@Transactional
	public void cancelarReserva(Long id, Usuario usuario) {
		
		Reserva reserva = reservaDAO.pesquisarReservaPorId(id);
		
		if (usuario instanceof Cliente)
			reserva.setStatus(StatusReserva.RESERVA_CANCELADA_CLIENTE);
		else
			reserva.setStatus(StatusReserva.RESERVA_CANCELADA_HOTEL);
		
		reservaDAO.salvar(reserva);
		
	}

	@Override
	@Transactional
	public List<Reserva> pesquisarReservaPorIntervaloDatas(LocalDateTime dataInico, LocalDateTime dataFim) {
		return reservaDAO.pesquisarReservaPorIntervaloDatas(dataInico, dataFim);
	}

}