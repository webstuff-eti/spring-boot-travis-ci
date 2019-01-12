package br.eti.webstuff.api.web.controller.empresa;

import java.security.NoSuchAlgorithmException;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.eti.webstuff.api.web.controller.responses.Response;
import br.eti.webstuff.api.web.dto.request.EmpresaRequestDto;
import br.eti.webstuff.api.web.dto.response.EmpresaResponseDto;

public interface IEmpresaController {

	public ResponseEntity<Response<EmpresaResponseDto>> buscarPorCnpj(@PathVariable("cnpj") String documento);

	public ResponseEntity<Response<EmpresaResponseDto>> cadastrar(@Valid @RequestBody EmpresaRequestDto empresaDto,
			BindingResult result) throws NoSuchAlgorithmException;

	public ResponseEntity<Response<EmpresaResponseDto>> atualizaEmpresaById(@PathVariable("id") Long id,
			@Valid @RequestBody EmpresaRequestDto empresaDto, BindingResult result) throws NoSuchAlgorithmException;

}
