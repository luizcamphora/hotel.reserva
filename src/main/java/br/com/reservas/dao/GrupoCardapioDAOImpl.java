package br.com.reservas.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.reservas.model.GrupoCardapio;

@Repository
public class GrupoCardapioDAOImpl implements GrupoCardapioDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void salvar(GrupoCardapio grupoCardapio) {
		sessionFactory.getCurrentSession().saveOrUpdate(grupoCardapio);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GrupoCardapio> pesquisarGrupoCardapios() {
		
		List<GrupoCardapio> grupoCardapios = sessionFactory.getCurrentSession().createQuery("from GrupoCardapio").list();
		
		for (GrupoCardapio grupoCardapio : grupoCardapios) {
			Hibernate.initialize(grupoCardapio.getItens());
		}
	
		return grupoCardapios;
	}

	@Override
	public void deletar(Long idGrupoCardapio) {
		GrupoCardapio grupoCardapio = (GrupoCardapio) sessionFactory.getCurrentSession().load(GrupoCardapio.class, idGrupoCardapio);
		if (null != grupoCardapio) {
			this.sessionFactory.getCurrentSession().delete(grupoCardapio);
		}
	}

	@Override
	public GrupoCardapio pesquisarGrupoCardapioPorId(Long idGrupoCardapio) {
		
		GrupoCardapio grupoCardapio = (GrupoCardapio) sessionFactory.getCurrentSession().get(GrupoCardapio.class, idGrupoCardapio);
		
		if (grupoCardapio != null) 
			Hibernate.initialize(grupoCardapio.getItens());
		
		return grupoCardapio;
	}

}
