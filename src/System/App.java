package System;

import TiposDeDados.Estado;
import TiposDeDados.MetodoPagamento;
import TiposDeDados.TipoCliente;
import TiposDeDados.UnidadeMedida;
import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
    	// Criação de endereços
    	ENDERECO endereco1 = new ENDERECO(Estado.SP, true);
    	ENDERECO endereco2 = new ENDERECO(Estado.MG, false);
    	ENDERECO endereco3 = new ENDERECO(Estado.DF, true);
    	
        // Criação de clientes
        CLIENTE cliente1 = new CLIENTE(TipoCliente.PADRAO, endereco1);
        CLIENTE cliente2 = new CLIENTE(TipoCliente.ESPECIAL, endereco2);
        CLIENTE cliente3 = new CLIENTE(TipoCliente.PRIME, endereco3);

        // Criação de produtos
        PRODUTO produto1 = new PRODUTO(1, "Produto A", 10.0f, UnidadeMedida.UN);
        PRODUTO produto2 = new PRODUTO(2, "Produto B", 20.0f, UnidadeMedida.KG);
        PRODUTO produto3 = new PRODUTO(3, "Produto C", 30.0f, UnidadeMedida.LT);

        // Criação de carrinhos de compras
        CARRINHO carrinho1 = new CARRINHO(cliente1);
        carrinho1.adicionarProduto(produto1, 2); // Adiciona 2 unidades do produto1
        carrinho1.adicionarProduto(produto2, 3); // Adiciona 3 quilos do produto2

        CARRINHO carrinho2 = new CARRINHO(cliente2);
        carrinho2.adicionarProduto(produto3, 1); // Adiciona 1 litro do produto3

        CARRINHO carrinho3 = new CARRINHO(cliente3);
        carrinho3.adicionarProduto(produto1, 1); // Adiciona 1 unidade do produto1
        carrinho3.adicionarProduto(produto2, 2); // Adiciona 2 quilos do produto2
        carrinho3.adicionarProduto(produto3, 1); // Adiciona 1 litro do produto3
        
        // Criação de vendas
        VENDA venda1 = new VENDA(LocalDate.now(), cliente1, carrinho1, MetodoPagamento.CARTAO_CREDITO, false);
        VENDA venda2 = new VENDA(LocalDate.now(), cliente2, carrinho2, MetodoPagamento.BOLETO, false);
        VENDA venda3 = new VENDA(LocalDate.now(), cliente3, carrinho3, MetodoPagamento.CARTAO_EMPRESA, true);
        

        // Exibir detalhes das vendas e totais calculados
        System.out.println("Detalhes da Venda 1: " + venda1);
        System.out.println("Total da Venda 1: " + venda1.calcularTotal());

        System.out.println("\nDetalhes da Venda 2: " + venda2);
        System.out.println("Total da Venda 2: " + venda2.calcularTotal());

        System.out.println("\nDetalhes da Venda 3: " + venda3);
        System.out.println("Total da Venda 3: " + venda3.calcularTotal());

        // Atualizar cashback após as vendas
        venda1.atualizarCashback(cliente1, venda1);
        venda2.atualizarCashback(cliente2, venda2);
        venda3.atualizarCashback(cliente3, venda3);
        
        // Exibir cashback atualizado dos clientes
        System.out.println("\nCashback do Cliente 1 após venda: " + cliente1.getCashback());
        System.out.println("Cashback do Cliente 2 após venda: " + cliente2.getCashback());
        System.out.println("Cashback do Cliente 3 após venda: " + cliente3.getCashback());
        
        // Verificando uma compra utilizando cashback acumulado da compra anterior
        CARRINHO carrinho4 = new CARRINHO(cliente3);
        carrinho4.adicionarProduto(produto1, 10);
        VENDA venda4 = new VENDA(LocalDate.now(), cliente3, carrinho4, MetodoPagamento.CARTAO_EMPRESA, true);
        System.out.println("\nDetalhes da Venda 4: " + venda4);
        System.out.println("Total da Venda 4: " + venda4.calcularTotal());
        System.out.println("Cashback do Cliente 3 após venda: " + cliente3.getCashback());
    }
}
