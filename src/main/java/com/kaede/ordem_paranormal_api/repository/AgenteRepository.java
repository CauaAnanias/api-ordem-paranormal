package com.kaede.ordem_paranormal_api.repository;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.kaede.ordem_paranormal_api.model.Agente;

@Repository
public interface AgenteRepository extends MongoRepository<Agente, String> {
List<Agente> findByClasseIgnoreCase(String classe);
	
}

