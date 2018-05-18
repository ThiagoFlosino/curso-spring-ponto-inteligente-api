package com.cursos.pontointeligente.api.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursos.pontointeligente.api.entity.Empresa;
import com.cursos.pontointeligente.api.repositories.EmpresaRepository;
import com.cursos.pontointeligente.api.services.EmpresaService;

@Service
public class EmpresaServiceImpl implements EmpresaService {
	
	private static final Logger log = LoggerFactory.getLogger(EmpresaServiceImpl.class);
	
	@Autowired
	private EmpresaRepository empresaRepository;

	@Override
	public Optional<Empresa> buscarPorCnpj(String Cnpj) {
		log.info("Buscando uma empresa para o CNPJ {}", Cnpj);
		return Optional.ofNullable(empresaRepository.findByCnpj(Cnpj));
	}

	@Override
	public Empresa persistir(Empresa empresa) {
		log.info("Persistindo Empresa: {}", empresa);
		return this.empresaRepository.save(empresa);
	}
	

}
