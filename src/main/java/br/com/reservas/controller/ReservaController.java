package br.com.reservas.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.reservas.model.Cliente;
import br.com.reservas.model.Quarto;
import br.com.reservas.model.Reserva;
import br.com.reservas.model.StatusReserva;
import br.com.reservas.model.Usuario;
import br.com.reservas.service.QuartoService;
import br.com.reservas.service.ReservaService;
import br.com.reservas.service.UsuarioService;
import br.com.reservas.utils.DataUtils;

@Controller
@RequestMapping("/reserva")
public class ReservaController {

	@Autowired
	private ReservaService reservaService;

	@Autowired
	private QuartoService quartoService;

	@Autowired
	private UsuarioService usuarioService;

	public ReservaController() {
	}

	@RequestMapping(value = "/lista")
	public ModelAndView listar(ModelAndView model, HttpServletRequest request) throws IOException {

		Usuario usuarioLogado = (Usuario) request.getSession().getAttribute("usuarioLogado");

		List<Reserva> listReserva = new ArrayList<Reserva>();

		if (usuarioLogado instanceof Cliente)
			listReserva = reservaService.pesquisarReservasPorUsuarioLogado(usuarioLogado);
		else
			listReserva = reservaService.pesquisarReservas();

		model.addObject("listReserva", listReserva);
		model.setViewName("reserva-lista");
		return model;

	}

	@RequestMapping(value = "/lista-aceitar-reservas")
	public ModelAndView listarAceitarReserva(ModelAndView model) throws IOException {
		List<Reserva> listReserva = reservaService.pesquisarReservasStatus(StatusReserva.RESERVA_REALIZADA);
		model.addObject("listReserva", listReserva);
		model.setViewName("reserva-lista-aceitar");
		return model;
	}
	
	@RequestMapping(value = "/ativar", method = RequestMethod.GET)
	public ModelAndView ativar(HttpServletRequest request) {
		Long id = Long.parseLong(request.getParameter("id"));
		reservaService.ativarReserva(id);

		ModelAndView model = new ModelAndView("reserva-dados");
		List<Reserva> listReserva = reservaService.pesquisarReservasStatus(StatusReserva.RESERVA_REALIZADA);
		model.addObject("listReserva", listReserva);
		model.addObject("sucesso", Boolean.TRUE);
		model.setViewName("reserva-lista-aceitar");
		return model;
	}


	@RequestMapping(value = "/lista-finalizar-reservas")
	public ModelAndView listarFinalizarReserva(ModelAndView model) throws IOException {
		List<Reserva> listReserva = reservaService.pesquisarReservasStatus(StatusReserva.RESERVA_ATIVA);
		model.addObject("listReserva", listReserva);
		model.setViewName("reserva-lista-finalizar");
		return model;
	}

	@RequestMapping(value = "/lista-cancelar-reservas")
	public ModelAndView listarCancelarReserva(ModelAndView model, HttpServletRequest request) throws IOException {

		Usuario usuarioLogado = (Usuario) request.getSession().getAttribute("usuarioLogado");

		List<Reserva> listReserva = new ArrayList<Reserva>();

		if (usuarioLogado instanceof Cliente)
			listReserva = reservaService.pesquisarReservasUsuarioStatus(usuarioLogado, StatusReserva.RESERVA_REALIZADA);
		else
			listReserva = reservaService.pesquisarReservasStatus(StatusReserva.RESERVA_REALIZADA);

		model.addObject("listReserva", listReserva);
		model.setViewName("reserva-lista-cancelar");
		return model;
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public ModelAndView salvar(@ModelAttribute Reserva reserva) {

		ModelAndView model = new ModelAndView();

		boolean datasValidas = validarDatasReserva(reserva.getDataCheckInStr(), reserva.getDataCheckOutStr());

		if (datasValidas) {
			reservaService.salvar(reserva);
			model.addObject("sucesso", Boolean.TRUE);
			model.setViewName("reserva-sucesso");
		} else {
			model.addObject("sucesso", Boolean.FALSE);
			model.addObject("mensagem", "A data de check out precisa ser maior que a data de check in.");
			model.setViewName("reserva-form");
			
		}
		Quarto quarto = quartoService.pesquisarQuartoPorId(reserva.getQuarto().getId());
		Usuario usuario = usuarioService.pesquisarUsuarioPorId(reserva.getUsuario().getId());

		reserva.setDataCheckInStr(DataUtils.converterLocalDateTimeParaStringDate(reserva.getDataCheckIn()));
		reserva.setDataCheckOutStr(DataUtils.converterLocalDateTimeParaStringDate(reserva.getDataCheckOut()));

		model.addObject("usuario", usuario);
		model.addObject("quarto", quarto);
		model.addObject("reserva", reserva);
		return model;
	}

	private boolean validarDatasReserva(String dataCheckInStr, String dataCheckOutStr) {

		LocalDateTime checkin = DataUtils.converterStringParaLocalDateTime(dataCheckInStr + " 00:00");
		LocalDateTime checkout = DataUtils.converterStringParaLocalDateTime(dataCheckOutStr + " 00:00");

		return checkin.isBefore(checkout);
	}

	@RequestMapping(value = "/deletar", method = RequestMethod.GET)
	public ModelAndView deletar(HttpServletRequest request) {

		Long id = Long.parseLong(request.getParameter("id"));
		reservaService.deletar(id);

		List<Reserva> listReserva = reservaService.pesquisarReservas();

		ModelAndView model = new ModelAndView();
		model.addObject("listReserva", listReserva);
		model.addObject("sucesso", Boolean.TRUE);
		model.setViewName("reserva-lista");
		return model;
	}

	@RequestMapping(value = "/editar", method = RequestMethod.GET)
	public ModelAndView editar(HttpServletRequest request) {
		Long id = Long.parseLong(request.getParameter("id"));
		Reserva reserva = reservaService.pesquisarReservaPorId(id);
		ModelAndView model = new ModelAndView("reserva-form");
		model.addObject("reserva", reserva);

		return model;
	}

	@RequestMapping(value = "/form-reserva", method = RequestMethod.GET)
	public ModelAndView formReserva(HttpServletRequest request, HttpSession session) {

		Long idQuarto = Long.parseLong(request.getParameter("id"));
		Quarto quarto = quartoService.pesquisarQuartoPorId(idQuarto);
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");

		ModelAndView model = new ModelAndView("reserva-form");
		model.addObject("quarto", quarto);
		model.addObject("usuario", usuario);
		return model;
	}

	@RequestMapping(value = "/exportar")
	public void exportar(HttpServletResponse response) {

		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheetEditoras = workbook.createSheet("Reservas");

		List<Reserva> lista = reservaService.pesquisarReservas();

		int rownum = 0;

		Row cabecalho = sheetEditoras.createRow(rownum++);

		Cell cellIdCab = cabecalho.createCell(0);
		cellIdCab.setCellValue("ID");

		Cell cellNomeCab = cabecalho.createCell(1);
		cellNomeCab.setCellValue("NOME");

		for (Reserva reserva : lista) {
			Row row = sheetEditoras.createRow(rownum++);
			int cellnum = 0;

			Cell cellId = row.createCell(cellnum++);
			cellId.setCellValue(reserva.getId());

			Cell cellCodigo = row.createCell(cellnum++);
			cellCodigo.setCellValue(reserva.getCodigo());
		}

		try {

			response.setHeader("Content-Disposition", "attachment;filename=\"reservas.xlsx\"");

			response.setHeader("Pragma", "public");
			response.setHeader("Cache-Control", "cache");
			response.setHeader("Cache-Control", "must-revalidate");
			response.setContentType("application/vnd.ms-excel");
			response.setContentLength(workbook.getBytes().length);

			OutputStream out = response.getOutputStream();
			out.write(workbook.getBytes(), 0, workbook.getBytes().length);
			out.flush();
			out.close();

			System.out.println("Arquivo Excel criado com sucesso!");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Arquivo não encontrado!");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Erro na edição do arquivo!");
		}

	}

	@RequestMapping(value = "/visualizar", method = RequestMethod.GET)
	public ModelAndView visualizar(HttpServletRequest request) {
		Long id = Long.parseLong(request.getParameter("id"));
		Reserva reserva = reservaService.pesquisarReservaPorId(id);
		ModelAndView model = new ModelAndView("reserva-dados");
		model.addObject("reserva", reserva);

		return model;
	}

	@RequestMapping(value = "/finalizar", method = RequestMethod.GET)
	public ModelAndView finalizar(HttpServletRequest request) {

		Long id = Long.parseLong(request.getParameter("id"));
		reservaService.finalizarReserva(id);

		ModelAndView model = new ModelAndView("reserva-dados");
		List<Reserva> listReserva = reservaService.pesquisarReservasStatus(StatusReserva.RESERVA_ATIVA);
		model.addObject("listReserva", listReserva);
		model.addObject("sucesso", Boolean.TRUE);
		model.setViewName("reserva-lista-finalizar");
		return model;
	}

	@RequestMapping(value = "/cancelar", method = RequestMethod.GET)
	public ModelAndView cancelar(HttpServletRequest request) {

		Usuario usuarioLogado = (Usuario) request.getSession().getAttribute("usuarioLogado");

		Long id = Long.parseLong(request.getParameter("id"));
		reservaService.cancelarReserva(id, usuarioLogado);
		
		List<Reserva> listReserva = new ArrayList<>();
		if (usuarioLogado instanceof Cliente)
			listReserva = reservaService.pesquisarReservasUsuarioStatus(usuarioLogado, StatusReserva.RESERVA_REALIZADA);
		else
			listReserva = reservaService.pesquisarReservas();
		
		ModelAndView model = new ModelAndView("reserva-dados");
		model.addObject("listReserva", listReserva);
		model.addObject("sucesso", Boolean.TRUE);
		model.setViewName("reserva-lista-cancelar");
		return model;
	}

}
