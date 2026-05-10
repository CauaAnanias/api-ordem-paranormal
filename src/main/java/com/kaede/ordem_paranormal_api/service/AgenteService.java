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
        // Escudo protetor: Se a patente vier nula, barra a criação na hora!
        if (agente.getPatente() == null) {
            throw new RuntimeException("A patente do agente não pode estar vazia!");
        }

        // Agora é seguro usar o toLowerCase(), pois você tem certeza que tem texto ali.
        String patenteMinusc = agente.getPatente().toLowerCase();
        
        // ... resto do seu código
    
        
        int limiteItens = 0;
        
        // Transformamos a patente em minúsculo para não dar erro se alguém digitar "RECRUTA" ou "recruta"
        switch(agente.getPatente().toLowerCase()) {
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