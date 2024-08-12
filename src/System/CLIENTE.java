package System;

import TiposDeDados.TipoCliente;

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