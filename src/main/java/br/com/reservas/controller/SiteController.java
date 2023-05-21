package br.com.reservas.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.reservas.model.Evento;
import br.com.reservas.model.Quarto;
import br.com.reservas.service.EventoService;
import br.com.reservas.service.QuartoService;

@Controller
@RequestMapping("/site")
public class SiteController {
	
	@Autowired
	private QuartoService quartoService;
	
	@Autowired
	private EventoService eventoService;
	
	@RequestMapping(value = "/about")
	public ModelAndView about(ModelAndView model) throws IOException {
		model.setViewName("site-about");
		return model;
	}
	
	@RequestMapping(value = "/quartos")
	public ModelAndView quartos(ModelAndView model) throws IOException {
		
		List<Quarto> quartos = quartoService.pesquisarQuartos();

		model.addObject("quartos", quartos);
		model.setViewName("site-quartos");
		return model;
	}
	
	@RequestMapping(value = "/eventos")
	public ModelAndView eventos(ModelAndView model) throws IOException {
		
		List<Evento> eventos = eventoService.pesquisarEventos();
		
		model.addObject("eventos", eventos);
		model.setViewName("site-eventos");
		return model;
	}
	
	@RequestMapping(value = "/contato")
	public ModelAndView contato(ModelAndView model) throws IOException {
		model.setViewName("site-contato");
		return model;
	}
	
	@RequestMapping(value = "/central-reservas")
	public ModelAndView centralReservas(ModelAndView model) throws IOException {
		model.setViewName("index-login");
		return model;
	}
	
}
