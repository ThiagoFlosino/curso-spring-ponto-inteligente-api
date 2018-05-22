package com.cursos.pontointeligente.api.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.cursos.pontointeligente.api.entity.Lancamento;

public interface LancamentoService {

	/**
	 * Retorna uma lista Paginada de Lançamentos de um determinado funcionario
	 * 
	 * @param Long FuncionarioID
	 * @param PageRequest pageRequest
	 * @return Page<Lancamento>
	 */
	
	Page<Lancamento> buscarPorFuncionarioId(Long funcionarioId, PageRequest pageRequest);
	
	/**
	 * Retorna um lancamento por ID
	 * 
	 * @param Long ID;
	 * @return Optional<Lancamento>
	 */
	Optional<Lancamento> buscarPorId(Long id);
	
	/**Persiste um Lancamento
	 * 
	 * @param lancamento
	 * @return
	 */
	
	Lancamento persistir(Lancamento lancamento);
	
	/**
	 * Remove um Lancamento
	 * @param id
	 */
	
	void remover(Long id);
}
