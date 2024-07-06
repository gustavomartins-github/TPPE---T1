package app;

import java.util.Date;
import java.util.List;

public class Venda {
    private Date data;
    private client cliente;
    private List<ItemVenda> itensVendidos;
    private String metodoPagamento;
    private float valorTotal;
    private float valorFrete;
    private float valorICMS;
    private float valorImpostoMunicipal;
    private float desconto;
    private float cashbackUsado;

    public Venda(Date data, client cliente, List<ItemVenda> itensVendidos, String metodoPagamento) {
        this.data = data;
        this.cliente = cliente;
        this.itensVendidos = itensVendidos;
        this.metodoPagamento = metodoPagamento;
        this.valorFrete = 0.0f;
        this.valorICMS = 0.0f;
        this.valorImpostoMunicipal = 0.0f;
        this.desconto = 0.0f;
        this.cashbackUsado = 0.0f;
        calcularTotais();
    }

    private void calcularTotais() {
        for (ItemVenda item : itensVendidos) {
            float valorProdutos = item.getProduto().getValorVenda() * item.getQuantidade();
            valorFrete += calcularFrete(item);
            calcularImpostos(item, valorProdutos);
            calcularDescontos(item, valorProdutos);
        }
        calcularValorTotal();
    }

    private void calcularImpostos(ItemVenda item, float valorProdutos) {
        float taxaICMS;
        float taxaImpostoMunicipal;

        if (cliente.getUf().equals("DF")) {
            taxaICMS = 0.18f; 
            taxaImpostoMunicipal = 0.00f; 
        } else {
            taxaICMS = 0.12f; 
            taxaImpostoMunicipal = 0.04f; 
        }

        this.valorICMS += valorProdutos * taxaICMS;
        this.valorImpostoMunicipal += valorProdutos * taxaImpostoMunicipal;
    }

    private float calcularFrete(ItemVenda item) {
        float valorFrete;

        switch (cliente.getRegiao()) {
            case 0: // DF
                valorFrete = cliente.isInterior() ? 0.00f : 5.00f;
                break;
            case 1: // Região Centro-Oeste
                valorFrete = cliente.isInterior() ? 13.00f : 10.00f;
                break;
            case 2: // Região Nordeste
                valorFrete = cliente.isInterior() ? 18.00f : 15.00f;
                break;
            case 3: // Região Norte
                valorFrete = cliente.isInterior() ? 25.00f : 20.00f;
                break;
            case 4: // Região Sudeste
                valorFrete = cliente.isInterior() ? 10.00f : 7.00f;
                break;
            case 5: // Região Sul
                valorFrete = cliente.isInterior() ? 13.00f : 10.00f;
                break;
            default:
                valorFrete = 0.00f;
                break;
        }

        if (cliente.isPrime()) {
            valorFrete = 0.00f;
        } else if (cliente.isEspecial()) {
            valorFrete *= 0.70f; 
        }

        return valorFrete;
    }

    private void calcularDescontos(ItemVenda item, float valorProdutos) {
        if (cliente.isEspecial()) {
        	// 10% de desconto 
            if (valorProdutos > 100.00f) {
                desconto += valorProdutos * 0.10f; 
            }
        }

        if (cliente.isPrime()) {
            desconto += valorProdutos * (metodoPagamento.equals("Cartao de Credito da Empresa") ? 0.10f : 0.00f); 
            
            // Usar cashback acumulado como desconto
            if (cliente.getCashback() > 0) {
                cashbackUsado = Math.min(cliente.getCashback(), valorProdutos - desconto);
                desconto += cashbackUsado;
                cliente.setCashback(cliente.getCashback() - cashbackUsado);
            }
        }
    }

    private void calcularValorTotal() {
        float valorProdutos = 0.0f;
        for (ItemVenda item : itensVendidos) {
            valorProdutos += item.getProduto().getValorVenda() * item.getQuantidade();
        }
        valorTotal = valorProdutos + valorFrete + valorICMS + valorImpostoMunicipal - desconto;
    }

 
    public Date getData() {
        return data;
    }

    public client getCliente() {
        return cliente;
    }

    public List<ItemVenda> getItensVendidos() {
        return itensVendidos;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public float getValorFrete() {
        return valorFrete;
    }

    public float getValorICMS() {
        return valorICMS;
    }

    public float getValorImpostoMunicipal() {
        return valorImpostoMunicipal;
    }

    public float getDesconto() {
        return desconto;
    }

    public float getCashbackUsado() {
        return cashbackUsado;
    }
}
