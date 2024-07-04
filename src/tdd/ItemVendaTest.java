package tdd;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import app.ItemVenda;
import app.Produto;
import app.client;

@RunWith(Parameterized.class)
public class ItemVendaTest {

    private Produto produto;
    private int quantidade;
    private client cliente;
    private float esperadoICMS;
    private float esperadoImpostoMunicipal;
    private float esperadoFrete;

    public ItemVendaTest(Produto produto, int quantidade, client cliente, float esperadoICMS, float esperadoImpostoMunicipal, float esperadoFrete) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.cliente = cliente;
        this.esperadoICMS = esperadoICMS;
        this.esperadoImpostoMunicipal = esperadoImpostoMunicipal;
        this.esperadoFrete = esperadoFrete;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            { new Produto(1, "Caixa de Chocolate", 100.0f, "kg"), 2, new client(1, "João", "DF", false, false, false), 36.0f, 0.0f, 5.0f },
            { new Produto(2, "Pacote de Café", 50.0f, "kg"), 3, new client(2, "Maria", "SP", true, false, false), 18.0f, 6.0f, 10.0f },
            { new Produto(3, "Fardo de Arroz", 200.0f, "kg"), 1, new client(3, "Pedro", "GO", false, true, true), 24.0f, 8.0f, 10.0f },
            { new Produto(4, "Caixa de Leite", 30.0f, "litro"), 4, new client(4, "Ana", "BA", true, false, false), 14.4f, 4.8f, 18.0f },
            { new Produto(5, "Pacote de Farinha", 80.0f, "kg"), 5, new client(5, "Carlos", "RS", false, false, true), 48.0f, 16.0f, 10.0f }
            
        });
    }

    @Test
    public void testItemVenda() {
        ItemVenda itemVenda = new ItemVenda(produto, quantidade, cliente);

        assertEquals(esperadoICMS, itemVenda.getValorICMS(), 0.001);
        assertEquals(esperadoImpostoMunicipal, itemVenda.getValorImpostoMunicipal(), 0.001);
        assertEquals(esperadoFrete, itemVenda.getValorFrete(), 0.001);
    }
}
