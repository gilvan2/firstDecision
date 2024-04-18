package com.example.fd.firstdecision.repository;

import com.example.fd.firstdecision.orm.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    boolean existsByEmail(String email);
}
