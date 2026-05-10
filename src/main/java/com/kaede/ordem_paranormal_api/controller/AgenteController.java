package com.kaede.ordem_paranormal_api.controller;

import com.kaede.ordem_paranormal_api.model.Agente;
import com.kaede.ordem_paranormal_api.service.AgenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController


@RequestMapping("/agentes")


public class AgenteController {
	
	@DeleteMapping("/{id}")
	public void deletarAgente(@PathVariable String id) {
	    service.deletarAgente(id);
	}

    // APAGAMOS O REPOSITORY DAQUI E COLOCAMOS O SERVICE!
    @Autowired
    private AgenteService service;

    @PostMapping
    public Agente criarAgente(@RequestBody Agente agente) {
        // Agora o Controller manda pro Service validar a regra!
        return service.salvarFicha(agente);
    }
    
    // (A rota de GET pode ficar como estava antes, ou vamos arrumar depois. Foque no POST por enquanto!)
    @GetMapping
    public List<Agente> listarTodos() {
        return service.listarTodos();
    }
}