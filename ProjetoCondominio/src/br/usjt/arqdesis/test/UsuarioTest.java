package br.usjt.arqdesis.test;

import org.junit.Test;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.FixMethodOrder;

import br.usjt.arqdesis.model.Usuario;
import br.usjt.arqdesis.service.UsuarioService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UsuarioTest {


	Usuario usuario, copiaUsuario;
	UsuarioService service;
	static int id=0;
	
	@Before
	public void load(){
		usuario = new Usuario();
		usuario.setId(id);
		usuario.setCpf("101010");
		usuario.setNome("Victor");
		usuario.setEmail("test@gmail.com");
		usuario.setTelefone("12345678");
		usuario.setEmpresa("Empresa01");
		usuario.setUsername("victor10");
		usuario.setPassword("senha@123");
		service = new UsuarioService();
		
		copiaUsuario = usuario;
	}
	
	@Test
	public void test01CriarUsuario(){
		id = service.criar(usuario);
	}
	
	@Test
	public void test02AtualizarUsuario(){
		usuario.setNome("Test");
		usuario.setEmail("testtest@gmail.com");
		service.atualizar(usuario);
		service.carregar(id);
	}
	
	@Test
	public void test03ExcluirUsuario(){
		copiaUsuario.setId(-1);
		copiaUsuario.setCpf(null);
		copiaUsuario.setNome(null);
		copiaUsuario.setEmail(null);
		copiaUsuario.setTelefone(null);
		copiaUsuario.setEmpresa(null);
		copiaUsuario.setUsername(null);
		copiaUsuario.setPassword(null);
		service.excluir(id);
		service.carregar(id);
		assertEquals("Testa exclusão", usuario, copiaUsuario);
	}
	
	@Test
	public void test04SelectUsuario(){
		service.carregar(1);
	}
	
	
	
}
