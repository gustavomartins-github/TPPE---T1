package tdd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import app.Produto;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class TesteProduto {
    
    private int codigo;
    private String descricao;
    private float valorVenda;
    private String unidadeMedida;

    public TesteProduto(int codigo, String descricao, float valorVenda, String unidadeMedida) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.valorVenda = valorVenda;
        this.unidadeMedida = unidadeMedida;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            {1, "Produto 1", 10.0f, "unidade"},
            {2, "Produto 2", 20.0f, "kg"},
            {3, "Produto 3", 30.0f, "litro"}
        });
    }

    @Test
    public void testProduto() {
        Produto produto = new Produto(codigo, descricao, valorVenda, unidadeMedida);

        assertEquals(codigo, produto.getCodigo());
        assertEquals(descricao, produto.getDescricao());
        assertEquals(valorVenda, produto.getValorVenda(), 0.001);
        assertEquals(unidadeMedida, produto.getUnidadeMedida());
    }

    @Test
    public void testSetCodigo() {
        Produto produto = new Produto(codigo, descricao, valorVenda, unidadeMedida);
        produto.setCodigo(100);
        assertEquals(100, produto.getCodigo());
    }

    @Test
    public void testSetDescricao() {
        Produto produto = new Produto(codigo, descricao, valorVenda, unidadeMedida);
        produto.setDescricao("Novo Produto");
        assertEquals("Novo Produto", produto.getDescricao());
    }

    @Test
    public void testSetValorVenda() {
        Produto produto = new Produto(codigo, descricao, valorVenda, unidadeMedida);
        produto.setValorVenda(50.0f);
        assertEquals(50.0f, produto.getValorVenda(), 0.001);
    }

    @Test
    public void testSetUnidadeMedida() {
        Produto produto = new Produto(codigo, descricao, valorVenda, unidadeMedida);
        produto.setUnidadeMedida("metro");
        assertEquals("metro", produto.getUnidadeMedida());
    }
}
