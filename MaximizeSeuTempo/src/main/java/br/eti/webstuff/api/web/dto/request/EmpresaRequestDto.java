package br.eti.webstuff.api.web.dto.request;

public class EmpresaRequestDto {

	private String razaoSocial;
	private String cnpj;

	public EmpresaRequestDto() {

	}
	

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Override
	public String toString() {
		return "EmpresaDto [razaoSocial=" + razaoSocial + ", cnpj=" + cnpj + "]";
	}

}
