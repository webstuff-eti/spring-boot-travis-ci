package br.eti.webstuff.api.web.controller.funcionario;

import java.security.NoSuchAlgorithmException;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.eti.webstuff.api.entities.Funcionario;
import br.eti.webstuff.api.web.controller.funcionario.utils.IFuncionarioPessoaJuridicaUtil;
import br.eti.webstuff.api.web.controller.responses.Response;
import br.eti.webstuff.api.web.dto.request.PessoaJuridicaRequestDto;
import br.eti.webstuff.api.web.dto.response.PessoaJuridicaResponseDto;

@RestController
@RequestMapping("/api/pessoa/juridica")
@CrossOrigin("*")
public class FuncionarioPessoaJuridicaController implements IFuncionarioPessoaJuridicaController, IFuncionarioPessoaJuridicaUtil{

	@Override
	public void atualizaDadosFuncionarioPessoaFisica(Funcionario funcionario,
			PessoaJuridicaRequestDto pessoaJuridicaRequestDto, BindingResult result) throws NoSuchAlgorithmException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validarExistenciaDoFuncionarioPessoaFisicaParaCadastro(
			PessoaJuridicaRequestDto pessoaJuridicaRequestDto, BindingResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validarExistenciaDoFuncionarioPessoaFisicaParaAtualizacao(
			PessoaJuridicaRequestDto pessoaJuridicaRequestDto, BindingResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResponseEntity<Response<PessoaJuridicaResponseDto>> cadastrarPessoaFisica(
			PessoaJuridicaRequestDto pessoaJuridicaRequestDto, BindingResult result) throws NoSuchAlgorithmException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Response<PessoaJuridicaResponseDto>> buscarPorCpf(String documento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Response<PessoaJuridicaResponseDto>> atualizarPessoaFisicaById(Long id,
			PessoaJuridicaRequestDto pessoaJuridicaRequestDto, BindingResult result) throws NoSuchAlgorithmException {
		// TODO Auto-generated method stub
		return null;
	}

}
