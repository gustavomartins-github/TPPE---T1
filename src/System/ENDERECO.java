package System;

import java.util.HashMap;
import java.util.Map;
import TiposDeDados.Estado;
import TiposDeDados.Regiao;

/* Classe gerada pela atividade de refatoração Extrair Classe sobre a classe CLIENTE.

    Essa classe (ENDERERCO) é responsável pelas informações de endereço de um cliente que,
    no caso do sistema atual, consistem no estado em que a pessoa vive (utilizado para descobrir
    sua respectiva região) e a informação de que essa localização é a capital ou não. Tais
    informações impactam no cálculo do frete de uma venda que, por sua vez, impacta no valor 
    total dessa venda.

    Por fim, a criação dessa classe impacta na forma como as outras classes acessam a informação,
    pois originalmente era feita de maneira direta sobre a classe CLIENTE, sendo agora necessário
    acessar as informações de endreço a partir de um objeto ENDERECO contido em um objeto CLIENTE.

*/
public class ENDERECO {

	private Estado estado;
    private boolean capital;
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
    
    
    
    public ENDERECO(Estado estado, boolean capital) {
		super();
		this.estado = estado;
		this.capital = capital;
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
	
	public static Regiao getVerificarRegiao(Estado estado) {
		return verificarRegiao.get(estado);
	}
    
}

