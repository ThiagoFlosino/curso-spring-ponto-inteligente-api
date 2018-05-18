package com.cursos.pontointeligente.api.services;

import java.util.Optional;

import com.cursos.pontointeligente.api.entity.Empresa;

public interface EmpresaService {

	/**
	 * Retorna uma empresa dado um CNPJ
	 * 
	 * @param cnpj
	 * @return Optional<Empresa>
	 */
	Optional<Empresa> buscarPorCnpj(String Cnpj);
	
	/**
	 * Cadastra uma nova empresa
	 * 
	 * @param empresa
	 * @return Empresa
	 */
	Empresa persistir(Empresa empresa);
	
}
