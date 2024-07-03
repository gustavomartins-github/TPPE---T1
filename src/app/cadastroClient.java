package app;

import java.util.ArrayList;


public class cadastroClient {
	
	private ArrayList<client> clientes;
    
    public cadastroClient() {
    	clientes = new ArrayList<>();
    }
    
    public int adicionaClient(int id, String nome, String uf, boolean isInterior, boolean especial, boolean prime, float cashback) {
    	
    	clientes.add(new client(id, nome, uf, isInterior, especial, prime, cashback));
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
    
    public boolean adicionarCashback(int id, float addCashback) {
    	int idx = procuraId(id);
    	if(idx == -1) {
    		return false;
    	} else {
    		client clienteCashback = clientes.get(idx);
    		float cashbackTotal = clienteCashback.getCashback() + addCashback;
    		clienteCashback.setCashback(cashbackTotal);
    		return true;
    	}
    }
    
    public float usarCashback(int id) {
    	int idx = procuraId(id);
    	if(idx == -1) {
    		return -1f;
    	} else {
    		client clienteCashback = clientes.get(idx);
    		float cashbackAtual = clienteCashback.getCashback();
    		clienteCashback.setCashback(0.0f);
    		return cashbackAtual;
    	}
    }
    
}

