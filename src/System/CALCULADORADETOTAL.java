package System;

/* Classe resultante da atividade de refatoração "Substituir método por objeto-método" sobre o método calcularTotal na classe VENDA.
    
    Durante a aplicação dessa tecnica de refatoração, mais especificamente na etapa de movimentação da lógica do método fonte, uma 
    oportunidade de aplicação da técnica extrair método se fez presente sobre o bloco de código responsável por aplicar o cashback
    quando necessário, o que deu origem a mais um método: aplicarCashback.

*/
public class CALCULADORADETOTAL {
	private VENDA venda;

	public CALCULADORADETOTAL(VENDA venda) {
	    this.venda = venda;
	}
	
	public float calcular() {
        // Calcular o total dos itens no carrinho
        float totalCarrinho = venda.getItensVendidos().calcularTotal();

        // Calcular o valor do frete
        float frete = venda.calcularFrete(venda.getCliente());

        // Calcular o ICMS e o Imposto Municipal
        float icms = totalCarrinho * venda.calcularICMS(venda.getCliente());
        float impostoMunicipal = totalCarrinho * venda.calcularImpostoMunicipal(venda.getCliente());

     // Aplicar o cashback se necessário
        totalCarrinho = aplicarCashback(totalCarrinho);

        // Calcular o total da venda
        float totalVenda = totalCarrinho + frete + icms + impostoMunicipal;
        
        return totalVenda;
    }
	
	// Novo método extraído para aplicar o cashback
    private float aplicarCashback(float totalCarrinho) {
        float cashbackAplicado = 0;
        if (venda.isUsarCashback() && venda.getCliente().getCashback() > 0) {
            cashbackAplicado = Math.min(venda.getCliente().getCashback(), totalCarrinho);
            venda.getCliente().setCashback(venda.getCliente().getCashback() - cashbackAplicado);
            totalCarrinho -= cashbackAplicado;
        }
        return totalCarrinho;
    }
	
	
}


