package app;

import java.util.ArrayList;


public class cadastroClient {
	
	private ArrayList<client> clientes;
    
    public cadastroClient() {
    	clientes = new ArrayList<>();
    }
    
    public int adicionaClient(int id, String nome, String uf, boolean isInterior, boolean especial, boolean prime) {
    	
    	clientes.add(new client(id, nome, uf, isInterior, especial, prime));
    	client verifica = clientes.get(clientes.size() - 1);
    	
    	return verifica.getId();	
    }
    
    public int procuraId(int id) {
    	
    	int idx = -1;
    	
    	for(int i = 0; i < clientes.size(); i++) {
    		client searchClient;
    		searchClient = clientes.get(i);
    		if(id == searchClient.getId()) {
    			idx = i;
    			break;
    		}
    	}
    	
    	return idx;
    }
    
    public int deletarClient(int id) {
    	client clienteDeletado;
    	int idx = procuraId(id);
    	
    	if(idx == -1) {
    		return -1;
    	} else {
    		clienteDeletado = clientes.get(idx);
    		clientes.remove(idx);
    		return clienteDeletado.getId();
    	}
    }
    
    public static void main(String[] args) {
        cadastroClient cadastro = new cadastroClient();
        cadastro.adicionaClient(11, "roberto Marinho", "DF", false, false, false);
        System.out.println(cadastro.deletarClient(11));
    }
}

