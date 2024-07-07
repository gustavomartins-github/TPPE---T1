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
    
    // Calcular Frete
    public int calcularFrete (CLIENTE cliente) {
    	// Variaveis auxiliares
        Regiao regiaoCliente = CLIENTE.getVerificarRegiao(cliente.getEstado());
        int frete = 0;

        // Verificando valor do frete
        switch (regiaoCliente) {
	        case Regiao.DISTRITO_FEDERAL:
	        	if (cliente.isCapital() == true) {
	        		frete = 5;
	        	}
	        	else {
	        		frete = 0;
	        	}
	        case Regiao.REGIAO_CENTRO_OESTE:
	        	if (cliente.isCapital() == true) {
	        		frete = 10;
	        	}
	        	else {
	        		frete = 13;
	        	}
	        case Regiao.REGIAO_NORDESTE:  
	        	if (cliente.isCapital() == true) {
	        		frete = 15;
	        	}
	        	else {
	        		frete = 18;
	        	}
	        case Regiao.REGIAO_NORTE:  
	        	if (cliente.isCapital() == true) {
	        		frete = 20;
	        	}
	        	else {
	        		frete = 25;
	        	}
	        case Regiao.REGIAO_SUDESTE:  
	        	if (cliente.isCapital() == true) {
	        		frete = 7;
	        	}
	        	else {
	        		frete = 10;
	        	}
	        case Regiao.REGIAO_SUL:  
	        	if (cliente.isCapital() == true) {
	        		frete = 10;
	        	}
	        	else {
	        		return 13;
	        	}
        }
        
        // Aplicar desconto de frete para clientes especiais e prime
        if (cliente.getTipoCliente() == TipoCliente.PRIME) {
            frete = 0;
        } else if (cliente.getTipoCliente() == TipoCliente.ESPECIAL) {
            frete *= 0.7;
        }
        
        return frete;
    }
    
    // AtualizarCashback
    public void atualizarCashback (CLIENTE cliente, VENDA venda) {
    	if (cliente.getTipoCliente() == TipoCliente.PRIME) {
    		if (venda.getMetodoPagamento() == MetodoPagamento.CARTAO_EMPRESA) {
    			cliente.setCashback(venda.calcularTotal() * 0.05f);
    		}
    		else {
    			cliente.setCashback(venda.calcularTotal() * 0.03f);
    		}
    	}
    }
    
    // Calcular ICMS
    public float calcularICMS (CLIENTE cliente) {
    	if (cliente.getEstado() == Estado.DF) {
    		return 0.18f;
    	}
    	else {
    		return 0.12f;
    	}
    }
    
    // Calcular Imposto Municipal
    public float calcularImpostoMunicipal (CLIENTE cliente) {
    	if (cliente.getEstado() == Estado.DF) {
    		return 0f;
    	}
    	else {
    		return 0.04f;
    	}
    }
    
    // Calcular total da venda
    public float calcularTotal() {
        // Calcular o total dos itens no carrinho
        float totalCarrinho = itensVendidos.calcularTotal();

        // Calcular o valor do frete
        float frete = calcularFrete(cliente);

        // Calcular o ICMS e o Imposto Municipal
        float icms = totalCarrinho * calcularICMS(cliente);
        float impostoMunicipal = totalCarrinho * calcularImpostoMunicipal(cliente);

        // Aplicar o cashback se necessário
        float cashbackAplicado = 0;
        if (usarCashback && cliente.getCashback() > 0) {
            cashbackAplicado = Math.min(cliente.getCashback(), totalCarrinho);
            cliente.setCashback(cliente.getCashback() - cashbackAplicado);
            totalCarrinho -= cashbackAplicado;
        }

        // Calcular o total da venda
        float totalVenda = totalCarrinho + frete + icms + impostoMunicipal;

        return totalVenda;
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
