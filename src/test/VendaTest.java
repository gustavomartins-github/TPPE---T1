package test;

import static org.junit.Assert.assertEquals;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import System.*;
import TiposDeDados.*;

@RunWith(Parameterized.class)
public class VendaTest {

    private VENDA venda;

    // Configuração inicial para cada conjunto de testes
    @Before
    public void setUp() {
        // Exemplo de configuração inicial para teste
        CLIENTE cliente = new CLIENTE(TipoCliente.PADRAO, Estado.SP, true);
        CARRINHO carrinho = new CARRINHO(cliente);
        venda = new VENDA(LocalDate.now(), cliente, carrinho, MetodoPagamento.DINHEIRO, false);
        carrinho.adicionarProduto(new PRODUTO(1, "Produto Teste", 100.0f, UnidadeMedida.UN), 1);
    }

    // Parâmetros para os testes
    @Parameters(name = "Estado: {0}, Método de Pagamento: {1}, Usar Cashback: {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            { Estado.DF, MetodoPagamento.CARTAO_EMPRESA, true },
            { Estado.SP, MetodoPagamento.DINHEIRO, false },
            { Estado.RJ, MetodoPagamento.CARTAO_EMPRESA, true }
        });
    }

    // Construtor para os parâmetros
    private Estado novoEstadoCliente;
    private MetodoPagamento novoMetodoPagamento;
    private boolean novoUsarCashback;

    public VendaTest(Estado estado, MetodoPagamento metodoPagamento, boolean usarCashback) {
        this.novoEstadoCliente = estado;
        this.novoMetodoPagamento = metodoPagamento;
        this.novoUsarCashback = usarCashback;
    }

    // Teste calcularFrete
    @Test
    public void testCalcularFrete() {
        venda.getCliente().setEstado(novoEstadoCliente);
        venda.setMetodoPagamento(novoMetodoPagamento);
        venda.setUsarCashback(novoUsarCashback);
        int resultado = venda.calcularFrete(venda.getCliente());
        int freteEsperado = calcularFreteEsperado(venda.getCliente());

        assertEquals(freteEsperado, resultado);
    }

    // Método auxiliar para calcular o frete esperado
    private int calcularFreteEsperado(CLIENTE cliente) {
        return venda.calcularFrete(cliente);
    }

    // Teste atualizarCashback
    @Test
    public void testAtualizarCashback() {
        venda.getCliente().setEstado(novoEstadoCliente);
        venda.setMetodoPagamento(novoMetodoPagamento);
        venda.setUsarCashback(novoUsarCashback);

        float cashbackAnterior = venda.getCliente().getCashback();
        venda.atualizarCashback(venda.getCliente(), venda);

        float cashbackEsperado = venda.calcularTotal() * (venda.getCliente().getTipoCliente() == TipoCliente.PRIME ? (novoMetodoPagamento == MetodoPagamento.CARTAO_EMPRESA ? 0.05f : 0.03f) : 0);
        assertEquals(cashbackEsperado, venda.getCliente().getCashback(), 0.001f);
    }

    // Teste calcularICMS
    @Test
    public void testCalcularICMS() {
        venda.getCliente().setEstado(novoEstadoCliente);
        venda.setMetodoPagamento(novoMetodoPagamento);
        venda.setUsarCashback(novoUsarCashback);
        float resultado = venda.calcularICMS(venda.getCliente());

        float icmsEsperado = venda.calcularICMS(venda.getCliente());
        assertEquals(icmsEsperado, resultado, 0.001f);
    }

    // Teste calcularImpostoMunicipal
    @Test
    public void testCalcularImpostoMunicipal() {
        venda.getCliente().setEstado(novoEstadoCliente);
        venda.setMetodoPagamento(novoMetodoPagamento);
        venda.setUsarCashback(novoUsarCashback);
        float resultado = venda.calcularImpostoMunicipal(venda.getCliente());

        float impostoMunicipalEsperado = venda.calcularImpostoMunicipal(venda.getCliente());
        assertEquals(impostoMunicipalEsperado, resultado, 0.001f);
    }

    // Teste calcularTotal
    @Test
    public void testCalcularTotal() {
        venda.getCliente().setEstado(novoEstadoCliente);
        venda.setMetodoPagamento(novoMetodoPagamento);
        venda.setUsarCashback(novoUsarCashback);
        float resultado = venda.calcularTotal();

        float totalEsperado = venda.calcularTotal();
        assertEquals(totalEsperado, resultado, 0.001f);
    }
}
