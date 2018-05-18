package com.cursos.pontointeligente.api.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.security.NoSuchAlgorithmException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.cursos.pontointeligente.api.entity.Empresa;
import com.cursos.pontointeligente.api.entity.Funcionario;
import com.cursos.pontointeligente.api.enums.PerfilEnum;
import com.cursos.pontointeligente.api.utils.PasswordUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class FuncionarioRepositoryTest{

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	@Autowired
	private EmpresaRepository empresaRepository;
	
	private static final String email = "email@email.com.br";
	private static final String cpf = "02250323097";
	
	@Before
	public void setUp() throws NoSuchAlgorithmException {
		Empresa empresa = this.empresaRepository.save(obterDadosEmpresa());
		this.funcionarioRepository.save(obterDadosFuncionario(empresa));
	}
	
	@After
	public final void tearDown() {
		this.empresaRepository.deleteAll();
	}
	
	@Test
	public void testBuscarFuncionarioPorEmail() {
		Funcionario funcionario = this.funcionarioRepository.findByEmail(email);
		assertEquals(email, funcionario.getEmail());
	}
	
	@Test
	public void testBuscarFuncionarioPorCpf() {
		Funcionario funcionario = this.funcionarioRepository.findByCpf(cpf);
		assertEquals(cpf, funcionario.getCpf());
	}
	
	@Test
	public void testBuscarFuncionarioPorCpfOrEmail() {
		Funcionario funcionario = this.funcionarioRepository.findByCpfOrEmail(cpf,email);
		assertNotNull(funcionario);
	}
	
	@Test
	public void testBuscarFuncionarioPorCpfOrEmailComEmailInvalido() {
		Funcionario funcionario = this.funcionarioRepository.findByCpfOrEmail(cpf,"email@invalido.com");
		assertNotNull(funcionario);
	}
	
	@Test
	public void testBuscarFuncionarioPorCpfOrEmailComCpfInvalido() {
		Funcionario funcionario = this.funcionarioRepository.findByCpfOrEmail("123456789",email);
		assertNotNull(funcionario);
	}
	
	private Empresa obterDadosEmpresa() {
		Empresa empresa = new Empresa();
		empresa.setRazaoSocial("Empresa de exemplo");
		empresa.setCnpj("25831334000138");
		return empresa;
	}
	
	private Funcionario obterDadosFuncionario(Empresa empresa) throws NoSuchAlgorithmException{
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Funcionario de Teste");
		funcionario.setPerfil(PerfilEnum.ROLE_USUARIO);
		funcionario.setSenha(PasswordUtils.geraBCrypt("123456"));
		funcionario.setCpf(cpf);
		funcionario.setEmail(email);
		funcionario.setEmpresa(empresa);
		return funcionario;
	}
}
