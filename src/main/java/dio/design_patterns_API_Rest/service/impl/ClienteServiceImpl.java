package dio.design_patterns_API_Rest.service.impl;

import dio.design_patterns_API_Rest.model.Cliente;
import dio.design_patterns_API_Rest.model.ClienteRepository;
import dio.design_patterns_API_Rest.model.Endereco;
import dio.design_patterns_API_Rest.model.EnderecoRepository;
import dio.design_patterns_API_Rest.service.ClienteService;
import dio.design_patterns_API_Rest.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.get();
    }

    @Override
    public void inserir(Cliente cliente) {
        salvarClienteComCep(cliente);

    }

    private void salvarClienteComCep(Cliente cliente) {
        //checar se o endereco do cliente existe
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            //Caso o endereco nao exista, deve integrar com ViaCEP e persistir o retorno
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        //Inserir o cliente, vinculando o endereco (novo ou existente)
        clienteRepository.save(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        //buscar o cliente por ID, caso exista
        Optional<Cliente> clienteDb = clienteRepository.findById(id);
        if(clienteDb.isPresent()) {
            salvarClienteComCep(cliente);
        }
    }

    @Override
    public void deletar(Long id) {
        //deletar cliente por ID
        clienteRepository.deleteById(id);
    }
}
