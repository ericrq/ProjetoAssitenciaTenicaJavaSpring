package projeto.assitencia_tecnica.repository;

import org.springframework.data.repository.CrudRepository;
import projeto.assitencia_tecnica.models.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {
}