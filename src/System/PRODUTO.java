package System;

import TiposDeDados.UnidadeMedida;

public class PRODUTO {
	
	// Atributos
    private int codigo;
    private String descricao;
    private float valorVenda;
    private UnidadeMedida unidadeMedida;

    // Construtor
    public PRODUTO(int codigo, String descricao, float valorVenda, UnidadeMedida unidadeMedida) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.valorVenda = valorVenda;
        this.unidadeMedida = unidadeMedida;
    }

    // Getters e Setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(float valorVenda) {
        this.valorVenda = valorVenda;
    }

    public UnidadeMedida getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "codigo=" + codigo +
                ", descricao='" + descricao + '\'' +
                ", valorVenda=" + valorVenda +
                ", unidadeMedida='" + unidadeMedida + '\'' +
                '}';
    }
}
