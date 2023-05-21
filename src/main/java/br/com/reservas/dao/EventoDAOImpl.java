package br.com.reservas.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.reservas.model.Evento;

@Repository
public class EventoDAOImpl implements EventoDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void salvar(Evento evento) {
		sessionFactory.getCurrentSession().saveOrUpdate(evento);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Evento> pesquisarEventos() {
		return sessionFactory.getCurrentSession().createQuery("from Evento").list();
	}

	@Override
	public void deletar(Long idEvento) {
		Evento evento = (Evento) sessionFactory.getCurrentSession().load(Evento.class, idEvento);
		if (null != evento) {
			this.sessionFactory.getCurrentSession().delete(evento);
		}
	}

	@Override
	public Evento pesquisarEventoPorId(Long idEvento) {
		return (Evento) sessionFactory.getCurrentSession().get(Evento.class, idEvento);
	}

}
