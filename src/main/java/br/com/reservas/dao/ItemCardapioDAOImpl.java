package br.com.reservas.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.reservas.model.ItemCardapio;

@Repository
public class ItemCardapioDAOImpl implements ItemCardapioDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void salvar(ItemCardapio itemCardapio) {
		sessionFactory.getCurrentSession().saveOrUpdate(itemCardapio);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ItemCardapio> pesquisarItemCardapios() {
		return sessionFactory.getCurrentSession().createQuery("from ItemCardapio").list();
	}

	@Override
	public void deletar(Long idItemCardapio) {
		ItemCardapio itemCardapio = (ItemCardapio) sessionFactory.getCurrentSession().load(ItemCardapio.class, idItemCardapio);
		if (null != itemCardapio) {
			this.sessionFactory.getCurrentSession().delete(itemCardapio);
		}
	}

	@Override
	public ItemCardapio pesquisarItemCardapioPorId(Long idItemCardapio) {
		return (ItemCardapio) sessionFactory.getCurrentSession().get(ItemCardapio.class, idItemCardapio);
	}

}
