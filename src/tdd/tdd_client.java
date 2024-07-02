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

import app.client;
import app.cadastroClient;

public class tdd_client {
	
	private cadastroClient setCadastro;
	
	private int id;
	private String nome;
	private String uf;
	private boolean isInterior;
	private boolean especial;
	private boolean prime;
	
	@Before
	public void setup() {
		 setCadastro = new cadastroClient();
	}
//	
//	public tdd_client(Object[] clientes, int id, String nome, String uf, boolean isInterior, boolean especial, boolean prime) {
//		
//		this.clientes = clientes;
//		this.id = id;
//		this.nome = nome;
//		this.uf = uf;
//		this.isInterior = isInterior;
//		this.especial = especial;
//		this.prime = prime;
//	}
	
	@Test
	public void testCadastroCliente() {
		assertEquals(11, setCadastro.adicionaClient(11, "roberto Marinho", "DF", false, false, false));
		assertEquals(11, setCadastro.deletarClient(11));
	}
	
}
