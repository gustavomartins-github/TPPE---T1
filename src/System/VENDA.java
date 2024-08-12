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
    


    /* Método calcularFrete (REFATORADO)

        Ao aplicar a técnica de refatoração "Extrair Método" sobre o método calcularFrete, perecebe-se os seguintes efeitos:

        1) a partir do método fonte calcularFrete, foi criado dois novas métodos:
            - verrificaValorDoFrete (CLIENTE cliente, int frete)
            - aplicarDesconto(CLIENTE cliente, int frete)
        2) Redução da complexidade do método: o método fonte foi extraído em partes menores, facilitando o entendimento
        3) Melhoria na legibilidade: é mais agradável ler o método após a aplicação da refatoração Extrair Método
        4) Manutenção facilitade: é mais fácil realizar manutenção no método após o aumento de sua modularização por meio da criação de novos métodos
        5) Encapsulamento: a lógica mais complexa do método foi encapsulada em novos métodos, tornando a interação com o método mais facilitada

        Obs.: mais detalhes sobre essa atividade de refatoração pode ser vista no tópico 2 (Extrair Classe) do documento entitulado como "Explicação Detalhada - Refatoração.pdf" nesse repositório.
    */
    public int calcularFrete (CLIENTE cliente) {
    	// Variaveis auxiliares
        int frete = 0;
        
        frete = verificaValorDoFrete(cliente, frete);
        
        frete = aplicarDesconto(cliente, frete);
        
        return frete;
    }
    // método alvo gerado pela técnica Extrair método a parir do método fonte calcularFrete
    public int aplicarDesconto(CLIENTE cliente, int frete) {
    	if (cliente.getTipoCliente() == TipoCliente.PRIME) {
            frete = 0;
        } else if (cliente.getTipoCliente() == TipoCliente.ESPECIAL) {
            frete *= 0.7;
        }
    	return frete;
    }
    // método alvo gerado pela técnica Extrair método a partir do método fonte calcularFrete
    public int verificaValorDoFrete(CLIENTE cliente, int frete) {
    	cliente.getEndereco();
		Regiao regiaoCliente = ENDERECO.getVerificarRegiao(cliente.getEndereco().getEstado());
    	
    	switch (regiaoCliente) {
        case Regiao.DISTRITO_FEDERAL:
        	if (cliente.getEndereco().isCapital() == true) {
        		frete = 5;
        	}
        	else {
        		frete = 0;
        	}
        case Regiao.REGIAO_CENTRO_OESTE:
        	if (cliente.getEndereco().isCapital() == true) {
        		frete = 10;
        	}
        	else {
        		frete = 13;
        	}
        case Regiao.REGIAO_NORDESTE:  
        	if (cliente.getEndereco().isCapital() == true) {
        		frete = 15;
        	}
        	else {
        		frete = 18;
        	}
        case Regiao.REGIAO_NORTE:  
        	if (cliente.getEndereco().isCapital() == true) {
        		frete = 20;
        	}
        	else {
        		frete = 25;
        	}
        case Regiao.REGIAO_SUDESTE:  
        	if (cliente.getEndereco().isCapital() == true) {
        		frete = 7;
        	}
        	else {
        		frete = 10;
        	}
        case Regiao.REGIAO_SUL:  
        	if (cliente.getEndereco().isCapital() == true) {
        		frete = 10;
        	}
        	else {
        		return 13;
        	}
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
    	if (cliente.getEndereco().getEstado() == Estado.DF) {
    		return 0.18f;
    	}
    	else {
    		return 0.12f;
    	}
    }
    
    // Calcular Imposto Municipal
    public float calcularImpostoMunicipal (CLIENTE cliente) {
    	if (cliente.getEndereco().getEstado() == Estado.DF) {
    		return 0f;
    	}
    	else {
    		return 0.04f;
    	}
    }
    
    /* Método calcularTotal (REFATORADO)

        Ao aplicar a técnica de refatoração "Substituir método por objeto-método" sobre o método calcularTotal, perecebe-se os seguintes efeitos:

        1) A partir do método fonte calcularTotal, foi criado uma nova classe denominada CALCULADORADETOTAL. Nessa classe, se fez presente a necessidade de aplicação da técnica Extrair Método novamente 
        2) Melhoria da Coesão: o objeto-método foca em realizar uma única tarefa, promovendo o princípio da responsabilidade única.
        3) Maior facilidade em Teste Unitário: com a lógica dividida em métodos menores dentro do objeto-método, é mais fácil escrever testes unitários específicos e granulares, 
        o que pode aumentando a cobertura e a qualidade dos testes.
        4) Melhoria da Legibilidade: com a lógica complexa encapsulada em métodos menores dentro do objeto-método, o código se torna mais legível e compreensível,
        facilitando a leitura e a manutenção por outros desenvolvedores.
        5) Melhoria na escalabilidade: o objeto-método pode ser facilmente estendido para adicionar novas funcionalidades sem modificar a classe original, promovendo a escalabilidade e a flexibilidade do sistema

        Obs.: mais detalhes sobre essa atividade de refatoração pode ser vista no tópico 3 (Substituir método por objeto-método) do documento entitulado como "Explicação Detalhada - Refatoração.pdf" nesse repositório.
    */
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
