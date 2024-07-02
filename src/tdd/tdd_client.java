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

public class tdd_client {
	
	private client cliente;
	private Object[] clientes;
	
	private int id;
	private String nome;
	private String uf;
	private boolean isInterior;
	private boolean especial;
	private boolean prime;
	
	@Before
	public void setup() {
		cliente = new client();
	}
	
	public tdd_client(Object[] clientes, int id, String nome, String uf, boolean isInterior, boolean especial, boolean prime) {
		
		this.clientes = clientes;
		this.id = id;
		this.nome = nome;
		this.uf = uf;
		this.isInterior = isInterior;
		this.especial = especial;
		this.prime = prime;
	}
	
	@Test
	public void testCadastroCliente() {
		assertTrue(cliente.cadastrarClient(10, "Marcelo Rodrigues", "DF", false, false, false));
	}
}
