package test;

import static org.junit.Assert.assertEquals;
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
public class CarrinhoTest {

    private CLIENTE cliente;
    private CARRINHO carrinho;
    private PRODUTO produto1;
    private PRODUTO produto2;

    // Configuração inicial para cada conjunto de testes
    @Before
    public void setUp() {
        ENDERECO endereco1 = new ENDERECO(Estado.SP, true);
        cliente = new CLIENTE(TipoCliente.PADRAO, endereco1);
        carrinho = new CARRINHO(cliente);
        produto1 = new PRODUTO(1, "Produto A", 10.0f, UnidadeMedida.UN);
        produto2 = new PRODUTO(2, "Produto B", 15.0f, UnidadeMedida.UN);
    }

    // Parâmetros para os testes
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            // { produto, quantidade }
            { new PRODUTO(1, "Produto A", 10.0f, UnidadeMedida.UN), 2 },
            { new PRODUTO(2, "Produto B", 15.0f, UnidadeMedida.UN), 1 },
        });
    }

    // Construtor para os parâmetros
    private PRODUTO produtoParaTeste;
    private int quantidadeParaTeste;

    public CarrinhoTest(PRODUTO produto, int quantidade) {
        this.produtoParaTeste = produto;
        this.quantidadeParaTeste = quantidade;
    }

    // Teste adicionarProduto
    @Test
    public void testAdicionarProduto() {
        carrinho.adicionarProduto(produtoParaTeste, quantidadeParaTeste);

        assertEquals(1, carrinho.getProdutos().size());
        assertEquals(1, carrinho.getQuantidades().size());
        assertEquals(produtoParaTeste, carrinho.getProdutos().get(0));
        assertEquals(quantidadeParaTeste, (int) carrinho.getQuantidades().get(0));
    }

    // Teste removerProduto
    @Test
    public void testRemoverProduto() {
        carrinho.adicionarProduto(produtoParaTeste, quantidadeParaTeste);

        carrinho.removerProduto(produtoParaTeste);

        assertEquals(0, carrinho.getProdutos().size());
        assertEquals(0, carrinho.getQuantidades().size());
    }

    // Teste calcularTotal
    @Test
    public void testCalcularTotal() {
        carrinho.adicionarProduto(produtoParaTeste, quantidadeParaTeste);

        float totalEsperado = produtoParaTeste.getValorVenda() * quantidadeParaTeste;
        float totalCalculado = carrinho.calcularTotal();

        assertEquals(totalEsperado, totalCalculado, 0.001); // Comparação com precisão de 0.001
    }
}
