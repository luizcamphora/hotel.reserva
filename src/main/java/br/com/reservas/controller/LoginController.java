package br.com.reservas.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.reservas.model.Cliente;
import br.com.reservas.model.Usuario;
import br.com.reservas.service.ClienteService;
import br.com.reservas.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@Autowired
	private ClienteService clienteService;

	@RequestMapping(value = "login")
	public ModelAndView login(Usuario usuario, HttpSession session) throws IOException, GeneralSecurityException {

		Usuario usuarioGoogle = new Usuario();
		Usuario usuarioLogado = new Usuario();

		if (usuario.getCredential() != null && !usuario.getCredential().isEmpty()) {
			usuarioGoogle = loginService.extractGoogleLoginInfo(usuario.getCredential());
			usuarioLogado = loginService.realizarLoginGoogle(usuarioGoogle.getLogin());

			if (usuarioLogado == null) {
				clienteService.salvarExterno(new Cliente(usuarioGoogle.getNome(), usuarioGoogle.getEmail(), usuarioGoogle.getLogin()));
				usuarioLogado = loginService.realizarLoginGoogle(usuarioGoogle.getLogin());
			}

		} else {
			usuarioLogado = loginService.realizarLogin(usuario.getLogin(), usuario.getSenha());
		}

		ModelAndView model = new ModelAndView();

		if (usuarioLogado != null || (usuario.getCredential() != null && !usuario.getCredential().isEmpty())) {

			session.setAttribute("usuarioLogado", usuarioLogado);
			model.addObject("sucesso", Boolean.TRUE);
			model.setViewName("home");
			return model;
		}

		model.addObject("sucesso", Boolean.FALSE);
		model.setViewName("index");
		return model;
	}

	@RequestMapping("sair")
	public ModelAndView sair(HttpSession session) {
		session.invalidate();

		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		return model;
	}

}
