package br.eti.webstuff.api.security;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordSecurityTest {
	
	private static final String senha = "12345678";
	
	private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	
	@Test
	public void senhaNula() throws Exception {
		assertNull(PasswordSecurity.gerarBCrypt(null));
	}
	
	
	@Test
	public void geraSenhaHash() throws Exception {
		String senhaHashGerdada = PasswordSecurity.gerarBCrypt(senha);
		assertTrue(bCryptPasswordEncoder.matches(senha, senhaHashGerdada));	
	}

}
