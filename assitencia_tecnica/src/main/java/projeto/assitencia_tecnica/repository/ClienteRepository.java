package projeto.assitencia_tecnica.repository;

import org.springframework.data.repository.CrudRepository;
import projeto.assitencia_tecnica.models.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    Cliente findById(long id);
}
