package tdd;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/* import java.sql.Date; */

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import app.cadastroClient;
import app.client;

@RunWith(Parameterized.class)
public class tdd_client {
	
	private cadastroClient setCadastro;
	private int id;
	private String nome;
	private String uf;
	private boolean isInterior;
	private boolean especial;
	private boolean prime;
	private int respostaEsperada;
	
	@Before
	public void setup() {
		 setCadastro = new cadastroClient();
	}
	
	public tdd_client(int respostaEsperada, int id, String nome, String uf, boolean isInterior, boolean especial, boolean prime) {
		
		this.respostaEsperada = respostaEsperada;
		this.id = id;
		this.nome = nome;
		this.uf = uf;
		this.isInterior = isInterior;
		this.especial = especial;
		this.prime = prime;
	}
	
	@Parameters
	public static Collection<Object[]> getParameters() {
		
		Object[][] param1 = new Object[][] {
			{1, 1, "Roberto Marinho", "DF", false, false, false},
			{2, 2, "Axl Rose", "GO", true, true, true},
			{3, 3, "Milena Soares", "RS", true, false, true},
			{4, 4, "Hidetaka Miyazaki", "BA", true, false, true},
			{5, 5, "Casey Hudson", "RJ", false, false, true},
			{6, 6, "Shinji Mikami", "AM", false, true, true}
		};
		return Arrays.asList(param1);
	}
	
	@Test
	public void testCadastroCliente() {
		int resposta = setCadastro.adicionaClient(id, nome, uf, isInterior, especial, prime);
		assertEquals(respostaEsperada, resposta);
		
		int respostaDelete = setCadastro.deletarClient(id);
		assertEquals(respostaEsperada, respostaDelete);
	}
	
}
