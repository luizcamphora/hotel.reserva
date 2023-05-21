package br.com.reservas.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.reservas.model.Cliente;
import br.com.reservas.model.Evento;
import br.com.reservas.model.Funcionario;
import br.com.reservas.model.GrupoCardapio;
import br.com.reservas.model.Perfil;
import br.com.reservas.model.Quarto;
import br.com.reservas.model.Usuario;
import br.com.reservas.service.EventoService;
import br.com.reservas.service.GrupoCardapioService;
import br.com.reservas.service.PerfilService;
import br.com.reservas.service.QuartoService;
import br.com.reservas.service.UsuarioService;

@Controller
public class HomeController {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private PerfilService perfilService;
	
	@Autowired
	private QuartoService quartoService;
	
	@Autowired
	private GrupoCardapioService grupoCardapioService;
	
	@Autowired
	private EventoService eventoService;
	
	@RequestMapping(value = "/")
	public ModelAndView home(ModelAndView model) throws IOException {
		
		List<Quarto> quartos = quartoService.pesquisarQuartos();
		List<GrupoCardapio> grupoCardapio = grupoCardapioService.pesquisarGrupoCardapios();
		List<Evento> eventos = eventoService.pesquisarEventos();
		
		model.addObject("grupoCardapio", grupoCardapio);
		model.addObject("quartos", quartos);
		model.addObject("eventos", eventos);
		model.setViewName("index");
		return model;
	}
	
	@RequestMapping(value = "/meus-dados", method = RequestMethod.GET)
	public ModelAndView meusDados(HttpServletRequest request) {
		
		Long id = Long.parseLong(request.getParameter("id"));
		
		Usuario usuarioLogado = usuarioService.pesquisarUsuarioPorId(id);
		
		ModelAndView model = new ModelAndView();
		
		if (usuarioLogado instanceof Cliente) {
			Cliente cliente = (Cliente) usuarioLogado;
			model.addObject("cliente", cliente);
			model.setViewName("cliente-dados-pessoais-form");
		} else {
			Funcionario funcionario = (Funcionario) usuarioLogado;
			model.addObject("funcionario", funcionario);
			model.setViewName("funcionario-dados-pessoais-form");
		}
		
		List<Perfil> perfis = perfilService.pesquisarPerfils();
		model.addObject("perfis", perfis);
		return model;
	}
}
