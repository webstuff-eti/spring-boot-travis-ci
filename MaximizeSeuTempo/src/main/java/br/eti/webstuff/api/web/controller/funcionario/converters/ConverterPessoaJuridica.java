package br.eti.webstuff.api.web.controller.funcionario.converters;

import java.security.NoSuchAlgorithmException;

import org.springframework.validation.BindingResult;

import br.eti.webstuff.api.entities.Funcionario;
import br.eti.webstuff.api.enumerations.TipoPerfilUsuario;
import br.eti.webstuff.api.web.dto.request.PessoaJuridicaRequestDto;
import br.eti.webstuff.api.web.dto.response.PessoaJuridicaResponseDto;

public class ConverterPessoaJuridica {

	/**
	 * Converte os dados do PessoaJuridicaRequestDto para Funcionário.
	 * 
	 * @param pessoaJuridicaRequestDto
	 * @param result
	 * @return Funcionario
	 * @throws NoSuchAlgorithmException
	 */
	public Funcionario converterPessoaJuridicaRequestDtoParaFuncionario(
			PessoaJuridicaRequestDto pessoaJuridicaRequestDto, BindingResult result) throws NoSuchAlgorithmException {

		Funcionario funcionario = new Funcionario();
		if (pessoaJuridicaRequestDto != null) {
			funcionario.setPerfil(TipoPerfilUsuario.ROLE_ADMIN);
		}

		if (pessoaJuridicaRequestDto.getNome() != null) {
			funcionario.setNome(pessoaJuridicaRequestDto.getNome());
		}
		if (pessoaJuridicaRequestDto.getEmail() != null) {
			funcionario.setEmail(pessoaJuridicaRequestDto.getEmail());
		}
		if (pessoaJuridicaRequestDto.getCpf() != null) {
			funcionario.setCpf(pessoaJuridicaRequestDto.getCpf());
		}
		if (pessoaJuridicaRequestDto.getSenha() != null) {
			// funcionario.setSenha(PasswordSecurity.gerarBCrypt(pessoaJuridicaRequestDto.getSenha()));
			funcionario.setSenha("12345673");
		}

		return funcionario;
	}

	/**
	 * Converte Funcionário para PessoaJuridicaResponseDto.
	 * 
	 * @param funcionario
	 * @return PessoaJuridicaResponseDto
	 */
	public PessoaJuridicaResponseDto converterCadastroPFDto(Funcionario funcionario) {

		PessoaJuridicaResponseDto pessoaJuridicaResponseDto = new PessoaJuridicaResponseDto();

		if (funcionario.getId() != null) {
			pessoaJuridicaResponseDto.setId(funcionario.getId());
		}
		if (funcionario.getCpf() != null) {
			pessoaJuridicaResponseDto.setCpf(funcionario.getCpf());
		}
		if (funcionario.getEmpresa().getCnpj() != null) {
			pessoaJuridicaResponseDto.setCnpj(funcionario.getEmpresa().getCnpj());
		}
		if (funcionario.getEmail() != null) {
			pessoaJuridicaResponseDto.setEmail(funcionario.getEmail());
		}
		if (funcionario.getNome() != null) {
			pessoaJuridicaResponseDto.setNome(funcionario.getNome());
		}
		if (funcionario.getEmpresa().getRazaoSocial() != null) {
			pessoaJuridicaResponseDto.setRazaoSocial(funcionario.getEmpresa().getRazaoSocial());
		}
		if (funcionario.getSenha() != null) {
			pessoaJuridicaResponseDto.setSenha(funcionario.getSenha());
		}

		return pessoaJuridicaResponseDto;
	}

}
