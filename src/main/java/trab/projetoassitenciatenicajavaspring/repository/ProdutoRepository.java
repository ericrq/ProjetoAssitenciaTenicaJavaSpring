package trab.projetoassitenciatenicajavaspring.repository;

import org.springframework.data.repository.CrudRepository;

import trab.projetoassitenciatenicajavaspring.models.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {
}