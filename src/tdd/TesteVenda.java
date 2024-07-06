package tdd;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import app.ItemVenda;
import app.Produto;
import app.Venda;
import app.client;

@RunWith(Parameterized.class)
public class TesteVenda {

    private Date data;
    private client cliente;
    private List<ItemVenda> itensVendidos;
    private String metodoPagamento;
    private float totalEsperado;
    private float freteEsperado;
    private float ICMSEsperado;
    private float impostoMunicipalEsperado;
    private float descontoEsperado;
    private float cashbackUsadoEsperado;

    public TesteVenda(Date data, client cliente, List<ItemVenda> itensVendidos, String metodoPagamento, 
                     float totalEsperado, float freteEsperado, float ICMSEsperado, float impostoMunicipalEsperado, 
                     float descontoEsperado, float cashbackUsadoEsperado) {
        this.data = data;
        this.cliente = cliente;
        this.itensVendidos = itensVendidos;
        this.metodoPagamento = metodoPagamento;
        this.totalEsperado = totalEsperado;
        this.freteEsperado = freteEsperado;
        this.ICMSEsperado = ICMSEsperado;
        this.impostoMunicipalEsperado = impostoMunicipalEsperado;
        this.descontoEsperado = descontoEsperado;
        this.cashbackUsadoEsperado = cashbackUsadoEsperado;
    }

    @Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
            {
                new Date(), new client(1, "Kirk", "DF", false, false, false, 0),
                Arrays.asList(new ItemVenda(new Produto(1, "Humanidade", 100.00f, "unidade"), 2)),
                "Dinheiro", 
                241.00f, 5.00f, 36.00f, 0.0f, 0.0f, 0.0f
            },
            {
                new Date(), new client(2, "Artorias", "SP", true, true, false, 0),
                Arrays.asList(new ItemVenda(new Produto(2, "Ração de cachorro", 50.00f, "unidade"), 3)),
                "Cartao de Credito", 
                166.00f, 7.00f, 18.00f, 6.00f, 15.0f, 0.0f
            },
            {
                new Date(), new client(3, "Siegmeyer", "RJ", false, false, true, 20),
                Arrays.asList(new ItemVenda(new Produto(3, " Zweihander", 200.00f, "unidade"), 1)),
                "Outro Metodo", 
                212.00f, 0.0f, 24.00f, 8.00f, 20.0f, 20.0f
            }
        });
    }

    @Test
    public void testCalculosVenda() {
        Venda venda = new Venda(data, cliente, itensVendidos, metodoPagamento);
        

        assertEquals(totalEsperado, venda.getValorTotal(), 0.01f);
        assertEquals(freteEsperado, venda.getValorFrete(), 0.01f);
        assertEquals(ICMSEsperado, venda.getValorICMS(), 0.01f);
        assertEquals(impostoMunicipalEsperado, venda.getValorImpostoMunicipal(), 0.01f);
        assertEquals(descontoEsperado, venda.getDesconto(), 0.01f);
        assertEquals(cashbackUsadoEsperado, venda.getCashbackUsado(), 0.01f);
    }
}
