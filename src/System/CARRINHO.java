package System;

import java.util.ArrayList;
import java.util.List;

public class CARRINHO {

    // Atributos
    private CLIENTE cliente;
    private List<PRODUTO> produtos;
    private List<Integer> quantidades;

    // Construtor
    public CARRINHO(CLIENTE cliente) {
        this.cliente = cliente;
        this.produtos = new ArrayList<>();
        this.quantidades = new ArrayList<>();
    }

    // Método para adicionar um produto ao carrinho
    public void adicionarProduto(PRODUTO produto, int quantidade) {
        int index = produtos.indexOf(produto);
        if (index == -1) {
            produtos.add(produto);
            quantidades.add(quantidade);
        } else {
        	int novaQuantidade = quantidades.get(index) + quantidade;
            quantidades.set(index, novaQuantidade);
        }
    }

    // Método para remover um produto do carrinho
    public void removerProduto(PRODUTO produto) {
        int index = produtos.indexOf(produto);
        if (index != -1) {
            produtos.remove(index);
            quantidades.remove(index);
        }
    }

    // Método para calcular o total do carrinho
    public float calcularTotal() {
        float total = 0;
        for (int i = 0; i < produtos.size(); i++) {
            total += produtos.get(i).getValorVenda() * quantidades.get(i);
        }
        return total;
    }

    // Getters e Setters
    public CLIENTE getCliente() {
        return cliente;
    }

    public void setCliente(CLIENTE cliente) {
        this.cliente = cliente;
    }

    public List<PRODUTO> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<PRODUTO> produtos) {
        this.produtos = produtos;
    }

    public List<Integer> getQuantidades() {
        return quantidades;
    }

    public void setQuantidades(List<Integer> quantidades) {
        this.quantidades = quantidades;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CARRINHO{");
        sb.append("cliente=").append(cliente);
        sb.append(", produtos=[");
        for (int i = 0; i < produtos.size(); i++) {
            sb.append("{produto=").append(produtos.get(i))
              .append(", quantidade=").append(quantidades.get(i))
              .append("}");
            if (i < produtos.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]}");
        return sb.toString();
    }
}
