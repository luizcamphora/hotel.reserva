package br.com.reservas.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.reservas.model.Reserva;
import br.com.reservas.model.StatusReserva;
import br.com.reservas.model.Usuario;

@Repository
public class ReservaDAOImpl implements ReservaDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void salvar(Reserva reserva) {
		sessionFactory.getCurrentSession().saveOrUpdate(reserva);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Reserva> pesquisarReservas() {
		return sessionFactory.getCurrentSession().createQuery("from Reserva").list();
	}

	@Override
	public void deletar(Long idReserva) {
		Reserva reserva = (Reserva) sessionFactory.getCurrentSession().load(Reserva.class, idReserva);
		if (null != reserva) {
			this.sessionFactory.getCurrentSession().delete(reserva);
		}
	}

	@Override
	public Reserva pesquisarReservaPorId(Long idReserva) {
		return (Reserva) sessionFactory.getCurrentSession().get(Reserva.class, idReserva);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Reserva> pesquisarReservasPorUsuarioLogado(Usuario usuario) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Reserva.class);
		criteria.add(Restrictions.eq("usuario.id", usuario.getId()));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Reserva> pesquisarReservasStatus(StatusReserva status) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Reserva.class);
		criteria.add(Restrictions.eq("status", status));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Reserva> pesquisarReservasUsuarioStatus(Usuario usuario, StatusReserva status) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Reserva.class);
		criteria.add(Restrictions.eq("usuario.id", usuario.getId()));
		criteria.add(Restrictions.eq("status", status));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Reserva> pesquisarReservaPorIntervaloDatas(LocalDateTime dataInicio, LocalDateTime dataFim) {
		
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Reserva.class);
		criteria.add(Restrictions.ge("dataReserva", dataInicio));
		criteria.add(Restrictions.lt("dataReserva", dataFim));

		return criteria.list();
	}

}
