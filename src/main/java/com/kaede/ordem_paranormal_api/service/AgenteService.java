package com.kaede.ordem_paranormal_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.kaede.ordem_paranormal_api.model.Agente;
import com.kaede.ordem_paranormal_api.repository.AgenteRepository;

@Service
public class AgenteService {

    @Autowired
    private AgenteRepository repository;
    
    public void deletarAgente(String id) {
        repository.deleteById(id);
    }

    public Agente salvarFicha(Agente agente) {
        if (agente.getPatente() == null) {
            throw new RuntimeException("A patente do agente não pode estar vazia!");
            
        }

        String patenteMinusc = agente.getPatente().toLowerCase();
        
        int limiteItens = 0;
        
        switch(patenteMinusc) {
            case "recruta": 
                limiteItens = 2; 
                break;
            case "operador": 
                limiteItens = 3; 
                break;
            case "agente especial": 
                limiteItens = 5; 
                break;
            default: 
                limiteItens = 1;
        }

        if (agente.getItens() != null && agente.getItens().size() > limiteItens) {
            throw new RuntimeException("Regra do Mestre: Um " + agente.getPatente() + " não pode ter mais que " + limiteItens + " itens no inventário!");
        }
        
        calcularStatusBase(agente);

        return repository.save(agente);
    }
    
    public List<Agente> listarTodos() {
        return repository.findAll();
    }
     
    @GetMapping("/buscar")
    public List<Agente> buscarPorClasse(String classe) {
        return repository.findByClasseIgnoreCase(classe);
    }
    
    private void calcularStatusBase(Agente agente) {
    	if(agente.getClasse() == null || agente.getNex() < 5 ) {
    		return;
    	}
    	
    	int nivel = agente.getNex() / 5;
    		String classeMinusc = agente.getClasse().toLowerCase();
    		
    		switch(classeMinusc) {
    			case "combatente":
    				agente.setVidaMaxima(20 + ((nivel - 1) * 4));
    				agente.setPeMaximo(2 + ((nivel - 1) *2));
    				agente.setSanidadeMaxima(12 + ((nivel - 1) *3));
    					break;
    			case "especialista":
    				agente.setVidaMaxima(16 + ((nivel - 1) * 3));
    				agente.setPeMaximo(3 + ((nivel - 1) * 3));
    				agente.setSanidadeMaxima(16 + ((nivel - 1) * 4));
    					break;
    			case "ocultista":
    				agente.setVidaMaxima(12 + ((nivel - 1) * 2));
    				agente.setPeMaximo(4 + ((nivel - 1) *4));
    				agente.setSanidadeMaxima(20 + ((nivel - 1) *5));
    					break;
    			default:
    				throw new RuntimeException("Classe inválida! Escolha Combatente, Especialista ou Ocultista");
    				
    		}
    }
}