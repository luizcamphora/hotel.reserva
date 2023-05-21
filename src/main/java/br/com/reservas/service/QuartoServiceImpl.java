package br.com.reservas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.reservas.dao.QuartoDAO;
import br.com.reservas.model.Quarto;
import br.com.reservas.utils.MoneyUtils;

@Service
public class QuartoServiceImpl implements QuartoService {

	@Autowired
	private QuartoDAO quartoDAO;

	@Override
	@Transactional
	public void salvar(Quarto quarto) {
		quarto.setValorDiaria(MoneyUtils.formatarValor(quarto.getValorDiariaStr()));
		quartoDAO.salvar(quarto);
	}

	@Override
	@Transactional
	public List<Quarto> pesquisarQuartos() {
		return quartoDAO.pesquisarQuartos();
	}

	@Override
	@Transactional
	public void deletar(Long idQuarto) {
		quartoDAO.deletar(idQuarto);
	}

	@Override
	@Transactional
	public Quarto pesquisarQuartoPorId(Long idQuarto) {
		Quarto quarto = quartoDAO.pesquisarQuartoPorId(idQuarto);
		quarto.setValorDiariaStr(MoneyUtils.formatarValor(quarto.getValorDiaria()));
		return quarto;
	}

}