package br.eti.webstuff.api.web.controller.funcionario.converters;

import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import org.springframework.validation.BindingResult;

import br.eti.webstuff.api.entities.Funcionario;
import br.eti.webstuff.api.enumerations.TipoPerfilUsuario;
import br.eti.webstuff.api.web.dto.request.PessoaFisicaRequestDto;
import br.eti.webstuff.api.web.dto.response.PessoaFisicaResponseDto;

public class ConverterPessoaFisica {
	
	
  /**
	* Converte os dados do PessoaFisicaRequestDto para Funcionário.
	* 
	* @param pessoaFisicaRequestDto
	* @param result
	* @return Funcionario
	* @throws NoSuchAlgorithmException
	*/
	private Funcionario converterPessoaFisicaRequestDtoParaFuncionario(PessoaFisicaRequestDto pessoaFisicaRequestDto, BindingResult result)
			throws NoSuchAlgorithmException {
		Funcionario funcionario = new Funcionario();
		funcionario.setNome(pessoaFisicaRequestDto.getNome());
		funcionario.setEmail(pessoaFisicaRequestDto.getEmail());
		funcionario.setCpf(pessoaFisicaRequestDto.getCpf());
		funcionario.setPerfil(TipoPerfilUsuario.ROLE_USUARIO);
		//TODO: A implementação de senha será desenvolvido com Spring Security
		//funcionario.setSenha(PasswordSecurity.gerarBCrypt(pessoaFisicaRequestDto.getSenha()));
		funcionario.setSenha("12345679");
		pessoaFisicaRequestDto.getQtdHorasAlmoco()
				.ifPresent(qtdHorasAlmoco -> funcionario.setQtdHorasAlmoco(Float.valueOf(qtdHorasAlmoco)));
		pessoaFisicaRequestDto.getQtdHorasTrabalhoDia()
				.ifPresent(qtdHorasTrabDia -> funcionario.setQtdHorasTrabalhoDia(Float.valueOf(qtdHorasTrabDia)));
		pessoaFisicaRequestDto.getValorHora().ifPresent(valorHora -> funcionario.setValorHora(new BigDecimal(valorHora)));

		return funcionario;
	}
	
	
	/**
	 * Converte Funcionário para PessoaFisicaResponseDto.
	 * 
	 * @param funcionario
	 * @return CadastroPFDto
	 */
	private PessoaFisicaResponseDto converterCadastroPFDto(Funcionario funcionario) {
		PessoaFisicaResponseDto pessoaFisicaResponseDto = new PessoaFisicaResponseDto();
		pessoaFisicaResponseDto.setId(funcionario.getId());
		pessoaFisicaResponseDto.setNome(funcionario.getNome());
		pessoaFisicaResponseDto.setEmail(funcionario.getEmail());
		pessoaFisicaResponseDto.setCpf(funcionario.getCpf());
		pessoaFisicaResponseDto.setCnpj(funcionario.getEmpresa().getCnpj());
		
		funcionario.getQtdHorasAlmocoOpt().ifPresent(qtdHorasAlmoco -> pessoaFisicaResponseDto
				.setQtdHorasAlmoco(Optional.of(Float.toString(qtdHorasAlmoco))));
		funcionario.getQtdHorasTrabalhoDiaOpt().ifPresent(
				qtdHorasTrabDia -> pessoaFisicaResponseDto.setQtdHorasTrabalhoDia(Optional.of(Float.toString(qtdHorasTrabDia))));
		funcionario.getValorHoraOpt()
				.ifPresent(valorHora -> pessoaFisicaResponseDto.setValorHora(Optional.of(valorHora.toString())));

		return pessoaFisicaResponseDto;
	}

}
