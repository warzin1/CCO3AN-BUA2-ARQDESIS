package br.usjt.arqdesis.test;

import br.usjt.arqdesis.model.Empresa;
import br.usjt.arqdesis.service.EmpresaService;

import org.junit.Test;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.FixMethodOrder;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmpresaTest {

	Empresa empresa, empresaCopia;
	EmpresaService service;
	static int id = 0;
	
	@Before
	public void load(){
		empresa = new Empresa();
		empresa.setId(id);
		empresa.setCnpj("1010");
		empresa.setRazaoSocial("Empresa 01");
		empresa.setHorarioEmpresa("8");
		empresa.setTemperaturaArCondicionado(23);
		empresa.setHorarioArCondicionado("8");
		
		service = new EmpresaService();
		
		empresaCopia = empresa;
	}
	
	@Test
	public void test01CriarEmpresa(){
		id = service.criar(empresa);
	}
	
	@Test
	public void test02AtualizarEmpresa(){
		empresa.setCnpj("2020");
		empresa.setRazaoSocial("Google");
		empresa.setHorarioEmpresa("8");
		empresa.setTemperaturaArCondicionado(23);
		empresa.setHorarioArCondicionado("8");
		service.atualizar(empresa);
		service.carregar(id);
	}
	
	@Test
	public void test03ExcluirEmpresa(){
		empresaCopia.setId(-1);
		empresaCopia.setCnpj(null);
		empresaCopia.setRazaoSocial(null);
		empresaCopia.setHorarioEmpresa(null);
		empresaCopia.setTemperaturaArCondicionado(Double.NaN);
		empresaCopia.setHorarioArCondicionado(null);
		service.excluir(id);
		service.carregar(id);
		assertEquals("Testa exclusão", empresa, empresaCopia);
	}
	
	@Test
	public void test04CarregarEmpresa(){
		service.carregar(1);
	}
}
