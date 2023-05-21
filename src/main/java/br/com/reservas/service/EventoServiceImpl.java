package br.com.reservas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.reservas.dao.EventoDAO;
import br.com.reservas.model.Evento;
import br.com.reservas.utils.DataUtils;

@Service
public class EventoServiceImpl implements EventoService {

	@Autowired
	private EventoDAO eventoDAO;

	@Override
	@Transactional
	public void salvar(Evento evento) {

		evento.setDataHoraEvento(DataUtils
				.converterStringParaLocalDateTime(evento.getDataEventoStr() + " " + evento.getHorarioEventoStr()));
		eventoDAO.salvar(evento);
	}

	@Override
	@Transactional
	public List<Evento> pesquisarEventos() {
		return eventoDAO.pesquisarEventos();
	}

	@Override
	@Transactional
	public void deletar(Long idEvento) {
		eventoDAO.deletar(idEvento);
	}

	@Override
	@Transactional
	public Evento pesquisarEventoPorId(Long idEvento) {
		Evento evento = eventoDAO.pesquisarEventoPorId(idEvento);
		evento.setDataEventoStr(DataUtils.converterLocalDateTimeParaStringDate(evento.getDataHoraEvento()));

		return evento;
	}

}