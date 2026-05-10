package com.kaede.ordem_paranormal_api.repository;

import com.kaede.ordem_paranormal_api.model.Agente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgenteRepository extends MongoRepository<Agente, String> {
}