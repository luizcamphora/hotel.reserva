package br.com.reservas.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.reservas.model.Quarto;

@Repository
public class QuartoDAOImpl implements QuartoDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void salvar(Quarto quarto) {
		sessionFactory.getCurrentSession().saveOrUpdate(quarto);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Quarto> pesquisarQuartos() {
		return sessionFactory.getCurrentSession().createQuery("from Quarto").list();
	}

	@Override
	public void deletar(Long idQuarto) {
		Quarto quarto = (Quarto) sessionFactory.getCurrentSession().load(Quarto.class, idQuarto);
		if (null != quarto) {
			this.sessionFactory.getCurrentSession().delete(quarto);
		}
	}

	@Override
	public Quarto pesquisarQuartoPorId(Long idQuarto) {
		return (Quarto) sessionFactory.getCurrentSession().get(Quarto.class, idQuarto);
	}

}
