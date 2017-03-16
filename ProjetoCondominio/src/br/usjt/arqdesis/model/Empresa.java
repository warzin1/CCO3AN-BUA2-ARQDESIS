package br.usjt.arqdesis.model;

public class Empresa {

	protected int id;
	
	protected String razaoSocial;
	protected String cnpj;
	protected String horarioEmpresa;
	protected double temperaturaArCondicionado;
	protected String horarioArCondicionado;
	
	public Empresa(){
		
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getHorarioEmpresa() {
		return horarioEmpresa;
	}
	public void setHorarioEmpresa(String horarioEmpresa) {
		this.horarioEmpresa = horarioEmpresa;
	}
	public double getTemperaturaArCondicionado() {
		return temperaturaArCondicionado;
	}
	public void setTemperaturaArCondicionado(double temperaturaArCondicionado) {
		this.temperaturaArCondicionado = temperaturaArCondicionado;
	}
	public String getHorarioArCondicionado() {
		return horarioArCondicionado;
	}
	public void setHorarioArCondicionado(String horarioArCondicionado) {
		this.horarioArCondicionado = horarioArCondicionado;
	}
	
	
}
