package com.mms.cliente.repository;

import com.mms.cliente.dto.ClienteDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends MongoRepository<ClienteDTO, Long> {
}
