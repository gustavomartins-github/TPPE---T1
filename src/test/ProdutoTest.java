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
public class ProdutoTest {

    private PRODUTO produto;

    // Configuração inicial para cada conjunto de testes
    @Before
    public void setUp() {
        // Configuração inicial do produto (exemplo)
        produto = new PRODUTO(1, "Produto A", 10.0f, UnidadeMedida.UN);
    }

    // Parâmetros para os testes
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            // { novoCodigo, novaDescricao, novoValorVenda, novaUnidadeMedida }
            { 2, "Produto B", 20.0f, UnidadeMedida.KG },
            { 3, "Produto C", 15.5f, UnidadeMedida.LT },
            { 4, "Produto D", 30.0f, UnidadeMedida.UN }
        });
    }

    // Construtor para os parâmetros
    private int novoCodigo;
    private String novaDescricao;
    private float novoValorVenda;
    private UnidadeMedida novaUnidadeMedida;

    public ProdutoTest(int codigo, String descricao, float valorVenda, UnidadeMedida unidadeMedida) {
        this.novoCodigo = codigo;
        this.novaDescricao = descricao;
        this.novoValorVenda = valorVenda;
        this.novaUnidadeMedida = unidadeMedida;
    }

    // Teste setCodigo
    @Test
    public void testSetCodigo() {
        produto.setCodigo(novoCodigo);
        assertEquals(novoCodigo, produto.getCodigo());
    }

    // Teste setDescricao
    @Test
    public void testSetDescricao() {
        produto.setDescricao(novaDescricao);
        assertEquals(novaDescricao, produto.getDescricao());
    }

    // Teste setValorVenda
    @Test
    public void testSetValorVenda() {
        produto.setValorVenda(novoValorVenda);
        assertEquals(novoValorVenda, produto.getValorVenda(), 0.001); // Comparação com precisão de 0.001
    }

    // Teste setUnidadeMedida
    @Test
    public void testSetUnidadeMedida() {
        produto.setUnidadeMedida(novaUnidadeMedida);
        assertEquals(novaUnidadeMedida, produto.getUnidadeMedida());
    }
}
