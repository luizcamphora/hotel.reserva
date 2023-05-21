package br.com.reservas.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.reservas.model.RelatorioReservas;
import br.com.reservas.model.Reserva;
import br.com.reservas.model.StatusReserva;
import br.com.reservas.service.ReservaService;
import br.com.reservas.utils.DataUtils;

@Controller
@RequestMapping("/relatorio")
public class RelatorioController {

	@Autowired
	private ReservaService reservaService;

	public RelatorioController() {
	}

	@RequestMapping(value = "/reservas")
	public ModelAndView reservas(ModelAndView model) throws IOException {
		model.setViewName("relatorio-filtro");
		model.addObject("dataInicio", LocalDate.now());
		model.addObject("dataFim", LocalDate.now());
		return model;
	}

	@RequestMapping(value = "/gerar")
	public ModelAndView gerarRelatorio(@ModelAttribute RelatorioReservas relatorio) throws IOException {

		ModelAndView model = new ModelAndView();
		model.addObject("dataInicio", relatorio.getDataInicio());
		model.addObject("dataFim", relatorio.getDataFim());
		model.addObject("dataInicioFormat",
				DataUtils.converterLocalDateParaString(LocalDate.parse(relatorio.getDataInicio())));
		model.addObject("dataFimFormat",
				DataUtils.converterLocalDateParaString(LocalDate.parse(relatorio.getDataFim())));

		model.setViewName("relatorio");
		return model;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/geral/dados", method = RequestMethod.GET)
	public @ResponseBody String getDados(@RequestParam("dataInicio") String dataInicio,
			@RequestParam("dataFim") String dataFim) throws IOException {

		List<Reserva> reservas = reservaService.pesquisarReservaPorIntervaloDatas(
				DataUtils.converterStringParaLocalDateTime(dataInicio + " 00:00"),
				DataUtils.converterStringParaLocalDateTime(dataFim + " 23:59"));

		long aguardandoAprovacao = 0;
		long ativa = 0;
		long finalizada = 0;
		long canceladaHotel = 0;
		long canceladaCliente = 0;

		for (Reserva reserva : reservas) {
			if (reserva.getStatus() == StatusReserva.RESERVA_REALIZADA)
				aguardandoAprovacao++;
			else if (reserva.getStatus() == StatusReserva.RESERVA_ATIVA)
				ativa++;
			else if (reserva.getStatus() == StatusReserva.RESERVA_FINALIZADA)
				finalizada++;
			else if (reserva.getStatus() == StatusReserva.RESERVA_CANCELADA_HOTEL)
				canceladaHotel++;
			else if (reserva.getStatus() == StatusReserva.RESERVA_CANCELADA_CLIENTE)
				canceladaCliente++;

		}

		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("mes", " ");
		jsonObject.put("reservas", reservas.size());
		jsonObject.put("aguardandoAprovacao", aguardandoAprovacao);
		jsonObject.put("ativa", ativa);
		jsonObject.put("finalizada", finalizada);
		jsonObject.put("canceladaHotel", canceladaHotel);
		jsonObject.put("canceladaCliente", canceladaCliente);

		jsonArray.add(jsonObject);

		return jsonArray.toJSONString();
	}

}
