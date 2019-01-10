package br.eti.webstuff.api.web.controller.empresa;

import java.security.NoSuchAlgorithmException;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.eti.webstuff.api.web.controller.responses.Response;
import br.eti.webstuff.api.web.dto.EmpresaDto;

public interface IEmpresaController {

	public ResponseEntity<Response<EmpresaDto>> buscarPorCnpj(@PathVariable("cnpj") String documento);

	public ResponseEntity<Response<EmpresaDto>> cadastrar(@Valid @RequestBody EmpresaDto empresaDto,
			BindingResult result) throws NoSuchAlgorithmException;

	public ResponseEntity<Response<EmpresaDto>> atualizaEmpresaById(@PathVariable("id") Long id,
			@Valid @RequestBody EmpresaDto empresaDto, BindingResult result) throws NoSuchAlgorithmException;

}
