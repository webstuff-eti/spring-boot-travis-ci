package br.eti.webstuff.api.service;

import java.util.Optional;

import br.eti.webstuff.api.entities.Empresa;

public interface EmpresaService {

	Optional<Empresa> buscarPorCnpj(String cnpj);

	Empresa persistir(Empresa empresa);

}
