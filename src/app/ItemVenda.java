package app;

public class ItemVenda {
    private Produto produto;
    private int quantidade;
    private float valorFrete;
    private float valorICMS;
    private float valorImpostoMunicipal;
    private client cliente; 

    public ItemVenda(Produto produto, int quantidade, client cliente) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.cliente = cliente;
        this.valorFrete = calcularFrete(); 
        calcularImpostos(); 
    }

    private void calcularImpostos() {
        float taxaICMS;
        float taxaImpostoMunicipal;

        if (cliente.getUf().equals("DF")) {
            taxaICMS = 0.18f; 
            taxaImpostoMunicipal = 0.00f; 
        } else {
            taxaICMS = 0.12f; 
            taxaImpostoMunicipal = 0.04f; 
        }

        this.valorICMS = produto.getValorVenda() * quantidade * taxaICMS;
        this.valorImpostoMunicipal = produto.getValorVenda() * quantidade * taxaImpostoMunicipal;
    }

    private float calcularFrete() {
        float valorFrete;

 
        switch (cliente.getRegiao()) {
            case 0: // DF
                valorFrete = cliente.isInterior() ? 0.00f : 5.00f;
                break;
            case 1: // Região Centro-Oeste
                valorFrete = cliente.isInterior() ? 13.00f : 10.00f;
                break;
            case 2: // Região Nordeste
                valorFrete = cliente.isInterior() ? 18.00f : 15.00f;
                break;
            case 3: // Região Norte
                valorFrete = cliente.isInterior() ? 25.00f : 20.00f;
                break;
            case 4: // Região Sudeste
                valorFrete = cliente.isInterior() ? 10.00f : 7.00f;
                break;
            case 5: // Região Sul
                valorFrete = cliente.isInterior() ? 13.00f : 10.00f;
                break;
            default:
                valorFrete = 0.00f;
                break;
        }

        return valorFrete;
    }


    public float getValorICMS() {
        return valorICMS;
    }

    public float getValorImpostoMunicipal() {
        return valorImpostoMunicipal;
    }

    public float getValorFrete() {
        return valorFrete;
    }
}
