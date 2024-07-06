package app;

import java.util.ArrayList;
import java.util.List;

public class CadastroVenda {
    private List<Venda> vendas;

    public CadastroVenda() {
        this.vendas = new ArrayList<>();
    }

    public void adicionarVenda(Venda venda) {
        vendas.add(venda);
    }

    public List<Venda> getVendas() {
        return vendas;
    }
}
