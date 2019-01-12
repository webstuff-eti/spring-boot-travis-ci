package br.eti.webstuff.api.web.controller.funcionario;

import java.security.NoSuchAlgorithmException;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.eti.webstuff.api.web.controller.responses.Response;
import br.eti.webstuff.api.web.dto.request.PessoaFisicaRequestDto;
import br.eti.webstuff.api.web.dto.response.PessoaFisicaResponseDto;

@RestController
@RequestMapping("/api/pessoa/fisica")
@CrossOrigin("*")
public class FuncionarioPessoaFisicaController implements IFuncionarioPessoaFisicaController {

	@Override
	public ResponseEntity<Response<PessoaFisicaResponseDto>> cadastrarPessoaFisica(
			PessoaFisicaRequestDto pessoaFisicaRequestDto, BindingResult result) throws NoSuchAlgorithmException {
		
		return null;
	}

	@Override
	public ResponseEntity<Response<PessoaFisicaResponseDto>> buscarPorCpf(String documento) {
		
		return null;
	}

	@Override
	public ResponseEntity<Response<PessoaFisicaResponseDto>> atualizarPessoaFisicaById(Long id,
			PessoaFisicaRequestDto pessoaFisicaRequestDto, BindingResult result) throws NoSuchAlgorithmException {
		
		return null;
	}
	
	

}
