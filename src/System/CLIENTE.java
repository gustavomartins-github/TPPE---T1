package System;

import java.util.HashMap;
import java.util.Map;
import TiposDeDados.Estado;
import TiposDeDados.Regiao;
import TiposDeDados.TipoCliente;


public class CLIENTE {
	
  	// Atributos
    private TipoCliente tipoCliente;
    private Estado estado;
    private boolean capital;
    private float cashback;
    
    // Construtor
    public CLIENTE(TipoCliente tipoCliente, Estado estado, boolean capital) {
        this.tipoCliente = tipoCliente;
        this.estado = estado;
        this.capital = capital;
        this.cashback = 0;
    }
    
	// Mapeamento de estados para regiões
    private static final Map<Estado, Regiao> verificarRegiao = new HashMap<>();
    static {
        verificarRegiao.put(Estado.DF, Regiao.DISTRITO_FEDERAL);
        verificarRegiao.put(Estado.GO, Regiao.REGIAO_CENTRO_OESTE);
        verificarRegiao.put(Estado.MT, Regiao.REGIAO_CENTRO_OESTE);
        verificarRegiao.put(Estado.MS, Regiao.REGIAO_CENTRO_OESTE);
        verificarRegiao.put(Estado.AL, Regiao.REGIAO_NORDESTE);
        verificarRegiao.put(Estado.BA, Regiao.REGIAO_NORDESTE);
        verificarRegiao.put(Estado.CE, Regiao.REGIAO_NORDESTE);
        verificarRegiao.put(Estado.MA, Regiao.REGIAO_NORDESTE);
        verificarRegiao.put(Estado.PB, Regiao.REGIAO_NORDESTE);
        verificarRegiao.put(Estado.PN, Regiao.REGIAO_NORDESTE);
        verificarRegiao.put(Estado.PI, Regiao.REGIAO_NORDESTE);
        verificarRegiao.put(Estado.RN, Regiao.REGIAO_NORDESTE);
        verificarRegiao.put(Estado.SE, Regiao.REGIAO_NORDESTE);
        verificarRegiao.put(Estado.AM, Regiao.REGIAO_NORTE);
        verificarRegiao.put(Estado.RR, Regiao.REGIAO_NORTE);
        verificarRegiao.put(Estado.RO, Regiao.REGIAO_NORTE);
        verificarRegiao.put(Estado.AP, Regiao.REGIAO_NORTE);
        verificarRegiao.put(Estado.TO, Regiao.REGIAO_NORTE);
        verificarRegiao.put(Estado.ES, Regiao.REGIAO_SUDESTE);
        verificarRegiao.put(Estado.MG, Regiao.REGIAO_SUDESTE);
        verificarRegiao.put(Estado.RJ, Regiao.REGIAO_SUDESTE);
        verificarRegiao.put(Estado.SP, Regiao.REGIAO_SUDESTE);
        verificarRegiao.put(Estado.PR, Regiao.REGIAO_SUL);
        verificarRegiao.put(Estado.SC, Regiao.REGIAO_SUL);
        verificarRegiao.put(Estado.RS, Regiao.REGIAO_SUL);
    }

	// Getters e Setters
    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public boolean isCapital() {
        return capital;
    }

    public void setCapital(boolean capital) {
        this.capital = capital;
    }

    public float getCashback() {
		return cashback;
	}

	public void setCashback(float cashback) {
		this.cashback = cashback;
	}
	
	public static Regiao getVerificarRegiao(Estado estado) {
		return verificarRegiao.get(estado);
	}
	
    @Override
    public String toString() {
        return "Cliente{" +
                "tipoCliente=" + tipoCliente +
                ", estado=" + estado +
                ", capital=" + capital +
                '}';
    }
}