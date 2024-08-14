package System;

import java.time.LocalDate;
import TiposDeDados.Estado;
import TiposDeDados.MetodoPagamento;
import TiposDeDados.Regiao;
import TiposDeDados.TipoCliente;

public class VENDA {
    
    // Atributos
    private LocalDate dataVenda;
    private CLIENTE cliente;
    private CARRINHO itensVendidos;
    private MetodoPagamento metodoPagamento;
    private boolean usarCashback;

    // Construtor
    public VENDA(LocalDate dataVenda, CLIENTE cliente, CARRINHO itensVendidos, MetodoPagamento metodoPagamento, boolean usarCashback) {
        this.dataVenda = dataVenda;
        this.cliente = cliente;
        this.itensVendidos = itensVendidos;
        this.metodoPagamento = metodoPagamento;
        this.usarCashback = usarCashback;
    }
    
    public int calcularFrete(CLIENTE cliente) {
        int frete = calcularValorBaseFrete(cliente);
        return aplicarDesconto(cliente, frete);
    }

    private int calcularValorBaseFrete(CLIENTE cliente) {
        Regiao regiaoCliente = ENDERECO.getVerificarRegiao(cliente.getEndereco().getEstado());

        if (cliente.getEndereco().isCapital()) {
            return calcularFreteParaCapital(regiaoCliente);
        } else {
            return calcularFreteParaInterior(regiaoCliente);
        }
    }

    private int calcularFreteParaCapital(Regiao regiaoCliente) {
        switch (regiaoCliente) {
            case DISTRITO_FEDERAL: return 5;
            case REGIAO_CENTRO_OESTE: return 10;
            case REGIAO_NORDESTE: return 15;
            case REGIAO_NORTE: return 20;
            case REGIAO_SUDESTE: return 7;
            case REGIAO_SUL: return 10;
            default: return 0;
        }
    }

    private int calcularFreteParaInterior(Regiao regiaoCliente) {
        switch (regiaoCliente) {
            case DISTRITO_FEDERAL: return 0;
            case REGIAO_CENTRO_OESTE: return 13;
            case REGIAO_NORDESTE: return 18;
            case REGIAO_NORTE: return 25;
            case REGIAO_SUDESTE: return 10;
            case REGIAO_SUL: return 13;
            default: return 0;
        }
    }

    private int aplicarDesconto(CLIENTE cliente, int frete) {
        switch (cliente.getTipoCliente()) {
            case PRIME:
                return 0;
            case ESPECIAL:
                return (int) (frete * 0.7);
            default:
                return frete;
        }
    }
    
    // Método atualizarCashback
    public void atualizarCashback(CLIENTE cliente, VENDA venda) {
        if (cliente.getTipoCliente() == TipoCliente.PRIME) {
            float cashback = venda.calcularTotal() * (venda.getMetodoPagamento() == MetodoPagamento.CARTAO_EMPRESA ? 0.05f : 0.03f);
            cliente.setCashback(cashback);
        }
    }
    
    // Método calcular ICMS
    public float calcularICMS(CLIENTE cliente) {
        return cliente.getEndereco().getEstado() == Estado.DF ? 0.18f : 0.12f;
    }
    
    // Método calcular Imposto Municipal
    public float calcularImpostoMunicipal(CLIENTE cliente) {
        return cliente.getEndereco().getEstado() == Estado.DF ? 0f : 0.04f;
    }

    public float calcularTotal() {
        return new CALCULADORADETOTAL(this).calcular();
    }
    
    // Getters e Setters
    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    public CLIENTE getCliente() {
        return cliente;
    }

    public void setCliente(CLIENTE cliente) {
        this.cliente = cliente;
    }

    public CARRINHO getItensVendidos() {
        return itensVendidos;
    }

    public void setItensVendidos(CARRINHO itensVendidos) {
        this.itensVendidos = itensVendidos;
    }

    public MetodoPagamento getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(MetodoPagamento metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public boolean isUsarCashback() {
        return usarCashback;
    }

    public void setUsarCashback(boolean usarCashback) {
        this.usarCashback = usarCashback;
    }

    @Override
    public String toString() {
        return "Venda{" +
                "dataVenda=" + dataVenda +
                ", cliente=" + cliente +
                ", itensVendidos=" + itensVendidos +
                ", metodoPagamento=" + metodoPagamento +
                '}';
    }
}
