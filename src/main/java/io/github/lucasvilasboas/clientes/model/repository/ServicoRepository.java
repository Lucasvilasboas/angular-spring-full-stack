package io.github.lucasvilasboas.clientes.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.lucasvilasboas.clientes.model.entity.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Integer>{

	
}
