package br.com.reservas.service;

import java.io.IOException;
import java.security.GeneralSecurityException;

import br.com.reservas.model.Usuario;

public interface LoginService {

	public Usuario realizarLogin(String login, String senha);

	public Usuario realizarLoginGoogle(String login);

	public Usuario extractGoogleLoginInfo(String credential) throws GeneralSecurityException, IOException;

}