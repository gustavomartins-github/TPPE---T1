package System;

import TiposDeDados.TipoCliente;

/* Classe CLIENTE (Refatorado) 

    Ao aplicar a técnica de refatoração "Extrair Classe" sobre a classe CLIENTE, perecebe-se os seguintes efeitos:

    1) a partir da classe fonte CLIENTE, foi criada uma nova classe denominada ENDERECO
    2) Melhoria na Coesão: a classe CLIENTE está mais focada nas responsabilidades intrísecas de um cliente, satisfazendo o "Princípio da Responsabilidade Única".
    3) Redução do Acoplamento: a extração da classe CLIENTE reduziu o acoplamento entre diferentes partes do código, uma vez que as dependências se tornam mais localizadas. 
    4) Organização do código: a extração da classe CLIENTE torna a estrutura do código mais organizada, onde funcionalidades relacionadas são agrupadas em classes dedicadas (coisas de cliente na classe CLIENTE)
    e coisas de endereço na classe ENDERECO. Isso facilita a navegação e a compreensão do código.
    5) Simplificação da classe original: a classe CLIENTE se tornou mais simples e e manejável, facilitando o entendimento e manutenção de seu código.
	6) mudança na foma como se tem acesso às informações de endereço do CLIENTE, pois os elementos que antes eram invocados diretamente sobre o CLIENTE, agora é invocado sobre uma instância de ENDERECO no CLIENTE
    
    Obs.: mais detalhes sobre essa atividade de refatoração pode ser vista no tópico 2 (Extrair Método) do documento entitulado como "Explicação Detalhada - Refatoração.pdf" nesse repositório.
*/
public class CLIENTE {
	
  	// Atributos
    private TipoCliente tipoCliente;
    private ENDERECO endereco;
    private float cashback;
    
    // Construtor
    public CLIENTE(TipoCliente tipoCliente, ENDERECO endereco) {
        this.tipoCliente = tipoCliente;
        this.endereco = endereco;
        this.cashback = 0;
    }

	// Getters e Setters
    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public ENDERECO getEndereco() {
		return endereco;
	}

	public void setEndereco(ENDERECO endereco) {
		this.endereco = endereco;
	}

    public float getCashback() {
		return cashback;
	}

	public void setCashback(float cashback) {
		this.cashback = cashback;
	}
	
	@Override
	public String toString() {
		return "CLIENTE [tipoCliente=" + tipoCliente + ", endereco=" + endereco + ", cashback=" + cashback + "]";
	}

}