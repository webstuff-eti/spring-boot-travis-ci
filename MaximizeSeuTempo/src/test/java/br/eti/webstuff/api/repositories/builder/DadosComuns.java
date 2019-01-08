package br.eti.webstuff.api.repositories.builder;

public class DadosComuns {

	private static final String CNPJ = "33637290000138";

	private static final String EMAIL = "tibaestiago@gmail.com";
	private static final String CPF = "20134865022";
	private static final String SENHA = "12345678";
	private static final String NOME = "Tiago Tibaes";
	private static final String CPF_INVALIDO = "12345678901";
	private static final String EMAIL_INVALIDO = "email@invalido.com";
	private static final String RAZAO_SOCIAL = "Web Stuff";

	public static String getCnpj() {
		return CNPJ;
	}

	public static String getEmail() {
		return EMAIL;
	}

	public static String getCpf() {
		return CPF;
	}

	public static String getSenha() {
		return SENHA;
	}

	public static String getNome() {
		return NOME;
	}

	public static String getCpfInvalido() {
		return CPF_INVALIDO;
	}

	public static String getEmailInvalido() {
		return EMAIL_INVALIDO;
	}

	public static String getRazaoSocial() {
		return RAZAO_SOCIAL;
	}

}
