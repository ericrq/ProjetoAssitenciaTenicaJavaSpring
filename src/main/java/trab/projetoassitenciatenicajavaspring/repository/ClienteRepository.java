package trab.projetoassitenciatenicajavaspring.repository;

import org.springframework.data.repository.CrudRepository;

import trab.projetoassitenciatenicajavaspring.models.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    Cliente findById(long id);
}
