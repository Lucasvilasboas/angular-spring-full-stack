package io.github.lucasvilasboas.clientes.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.lucasvilasboas.clientes.model.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	

}
