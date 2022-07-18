package dio.design_patterns_API_Rest.service;

import dio.design_patterns_API_Rest.model.Cliente;

/**
 * Interface que define o padrão (Strategy) no domínio de cliente. Com isso, podemos ter várias implementações
 * dessa mesma interface
 */

public interface ClienteService {

    Iterable<Cliente> buscarTodos();
    Cliente buscarPorId(Long id);
    void inserir(Cliente cliente);
    void atualizar(Long id, Cliente cliente);
    void deletar(Long id);
}
