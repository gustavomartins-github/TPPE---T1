package app;

import java.util.HashMap;

public class client {
	
	private int id;
	private String nome;
	private String uf;
	private int regiao;
	private boolean isInterior;
	private boolean especial;
	private boolean prime;
	
	
	HashMap<String, Integer> tabelaRegioes = new HashMap<>();
	
	public void adicioanesEstados() {
		tabelaRegioes.put("DF", 0);
		tabelaRegioes.put("GO", 1);
		tabelaRegioes.put("MT", 1);
		tabelaRegioes.put("MS", 1);
		tabelaRegioes.put("AL", 2);
		tabelaRegioes.put("BA", 2);
		tabelaRegioes.put("CE", 2);
		tabelaRegioes.put("MA", 2);
		tabelaRegioes.put("PB", 2);
		tabelaRegioes.put("PN", 2);
		tabelaRegioes.put("PI", 2);
		tabelaRegioes.put("RN", 2);
		tabelaRegioes.put("SE", 2);
		tabelaRegioes.put("AM", 3);
		tabelaRegioes.put("RR", 3);
		tabelaRegioes.put("RO", 3);
		tabelaRegioes.put("AP", 3);
		tabelaRegioes.put("TO", 3);
		tabelaRegioes.put("ES", 4);
		tabelaRegioes.put("MG", 4);
		tabelaRegioes.put("RJ", 4);
		tabelaRegioes.put("SP", 4);
		tabelaRegioes.put("PR", 5);
		tabelaRegioes.put("SC", 5);
		tabelaRegioes.put("RS", 5);
	}
	
	public client(int id, String nome, String uf, boolean isInterior, boolean especial, boolean prime) {
		
		adicioanesEstados();
		this.id = id;
		this.nome = nome;
		this.uf = uf;
		this.regiao = tabelaRegioes.get(uf); // Identifica região pelo estado
		this.isInterior = isInterior;
		this.especial = especial;
		this.prime = prime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public int getRegiao() {
		return regiao;
	}

	public void setRegiao(int regiao) {
		this.regiao = regiao;
	}

	public boolean isInterior() {
		return isInterior;
	}

	public void setInterior(boolean isInterior) {
		this.isInterior = isInterior;
	}

	public boolean isEspecial() {
		return especial;
	}

	public void setEspecial(boolean especial) {
		this.especial = especial;
	}

	public boolean isPrime() {
		return prime;
	}

	public void setPrime(boolean prime) {
		this.prime = prime;
	}
	
}
