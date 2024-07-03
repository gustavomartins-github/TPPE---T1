package tdd;

import static org.junit.Assert.assertEquals;

/* import java.sql.Date; */

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import app.cadastroClient;

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
	private float cashback;
	private float attCashback;
	
	@Before
	public void setup() {
		 setCadastro = new cadastroClient();
	}
	
	public tdd_client(int respostaEsperada, float attCashback, int id, String nome, String uf, boolean isInterior, boolean especial, boolean prime, float cashback) {
		
		this.respostaEsperada = respostaEsperada;
		this.attCashback = attCashback;
		this.id = id;
		this.nome = nome;
		this.uf = uf;
		this.isInterior = isInterior;
		this.especial = especial;
		this.prime = prime;
		this.cashback = cashback;
	}
	
	@Parameters
	public static Collection<Object[]> getParameters() {
		
		Object[][] param1 = new Object[][] {
			{1, 20.15f, 1, "Roberto Marinho", "DF", false, false, false, 0.0f},
			{2, 100.99f, 2, "Axl Rose", "GO", true, true, true, 0.0f},
			{3, 0.50f, 3, "Milena Soares", "RS", true, false, true, 0.0f},
			{4, 0.01f, 4, "Hidetaka Miyazaki", "BA", true, false, true, 0.0f},
			{5, 2.30f, 5, "Casey Hudson", "RJ", false, false, true, 0.0f},
			{6, 12.45f, 6, "Shinji Mikami", "AM", false, true, true, 0.0f}
		};
		return Arrays.asList(param1);
	}
	
	@Test
	public void testCadastroCliente() {
		int resposta = setCadastro.adicionaClient(id, nome, uf, isInterior, especial, prime, cashback);
		assertEquals(respostaEsperada, resposta);
	}
	
	@Test
	public void testDeletarCliente() {
		setCadastro.adicionaClient(id, nome, uf, isInterior, especial, prime, cashback);
		int resposta = setCadastro.deletarClient(id);
		assertEquals(respostaEsperada, resposta);
	}
	
	@Test
	public void testAdicionarCashback() {
		setCadastro.adicionaClient(id, nome, uf, isInterior, especial, prime, cashback);
		boolean resposta = setCadastro.adicionarCashback(id, attCashback);
		assertEquals(true, resposta);
	}
	
	@Test
	public void testUsarCashback() {
		setCadastro.adicionaClient(id, nome, uf, isInterior, especial, prime, attCashback);
		float resposta = setCadastro.usarCashback(id);
		assertEquals(attCashback, resposta, 0.1);
	}
}
