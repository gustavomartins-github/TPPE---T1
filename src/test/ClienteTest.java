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
public class ClienteTest {

    private CLIENTE cliente;

    // Configuração inicial para cada conjunto de testes
    @Before
    public void setUp() {
        // Configuração inicial do cliente (exemplo)
        cliente = new CLIENTE(TipoCliente.PADRAO, Estado.SP, true);
    }

    // Parâmetros para os testes
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            // { novoTipoCliente, novoEstado, novaCapital, novoCashback }
            { TipoCliente.ESPECIAL, Estado.RJ, false, 50.0f },
            { TipoCliente.PRIME, Estado.MG, true, 100.0f }
        });
    }

    // Construtor para os parâmetros
    private TipoCliente novoTipoCliente;
    private Estado novoEstado;
    private boolean novaCapital;
    private float novoCashback;

    public ClienteTest(TipoCliente tipoCliente, Estado estado, boolean capital, float cashback) {
        this.novoTipoCliente = tipoCliente;
        this.novoEstado = estado;
        this.novaCapital = capital;
        this.novoCashback = cashback;
    }

    // Teste setTipoCliente
    @Test
    public void testSetTipoCliente() {
        cliente.setTipoCliente(novoTipoCliente);
        assertEquals(novoTipoCliente, cliente.getTipoCliente());
    }

    // Teste setEstado
    @Test
    public void testSetEstado() {
        cliente.setEstado(novoEstado);
        assertEquals(novoEstado, cliente.getEstado());
    }

    // Teste setCapital
    @Test
    public void testSetCapital() {
        cliente.setCapital(novaCapital);
        assertEquals(novaCapital, cliente.isCapital());
    }

    // Teste setCashback
    @Test
    public void testSetCashback() {
        cliente.setCashback(novoCashback);
        assertEquals(novoCashback, cliente.getCashback(), 0.001); // Comparação com precisão de 0.001
    }
}
