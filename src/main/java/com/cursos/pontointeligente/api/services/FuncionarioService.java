package com.cursos.pontointeligente.api.services;

import java.util.Optional;

import com.cursos.pontointeligente.api.entity.Funcionario;

public interface FuncionarioService {
	
	/**
	 * Persiste um Funcionário na base de Dados
	 * 
	 * @param funcionario
	 * @return Funcionario
	 */
	Funcionario persistir(Funcionario funcionario);
	
	/**
	 * Busca e retorna um funcionario por CPF
	 * 
	 * @author thiago
	 * @param cpf
	 * @return Optional<Funcionario>
	 */
	Optional<Funcionario> buscarPorCpf(String cpf);
	
	/**
	 * Busca e retorna um funcionario por Email
	 * 
	 * @author thiago
	 * @param email
	 * @return Optional<Funcionario>
	 */
	Optional<Funcionario> buscarPorEmail(String email);
	
	
	/**
	 * Busca e retorna um funcionario por ID
	 * 
	 * @author thiago
	 * @param id
	 * @return Optional<Funcionario>
	 */
	Optional<Funcionario> buscarPorId(Long id);
	

}
