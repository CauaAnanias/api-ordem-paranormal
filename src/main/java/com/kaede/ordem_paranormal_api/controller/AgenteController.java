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


    @Autowired
    private AgenteService service;

    @PostMapping
    public Agente criarAgente(@RequestBody Agente agente) {

        return service.salvarFicha(agente);
    }
    

    @GetMapping("/buscar")
    public List<Agente> buscarPorClasse(@RequestParam String classe) {
        return service.buscarPorClasse(classe);
    }
}