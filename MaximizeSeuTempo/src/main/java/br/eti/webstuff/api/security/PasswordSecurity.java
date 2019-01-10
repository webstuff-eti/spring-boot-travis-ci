package br.eti.webstuff.api.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordSecurity {
	
	private static final Logger log = LoggerFactory.getLogger(PasswordSecurity.class);
	
	public PasswordSecurity() {
		
	}
	
	/*
	  Gera um hash utilizando o BCrypt.
	  
	  @param senha
	  @return String
	  
	  - retorna um Hash da senha informada pelo usuário
	*/
	
	/*
	public static String gerarBCrypt(String senha) {
		
		if(senha == null) {
			return senha;
		}
		
		log.info("Gerando hash com BCrypt.");
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder.encode(senha);
		
	}
	*/

}
