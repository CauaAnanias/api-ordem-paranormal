package com.kaede.ordem_paranormal_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
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

        return repository.save(agente);
    }
    
    public List<Agente> listarTodos() {
        return repository.findAll();
    }
}