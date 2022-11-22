package br.com.angular.service.impl;

import br.com.angular.model.entity.Cliente;
import br.com.angular.model.repository.ClienteRepository;
import br.com.angular.rest.dto.ClienteDTO;
import br.com.angular.rest.dto.ClienteUpdateDTO;
import br.com.angular.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente salvar(ClienteDTO clienteDTO) {
        Cliente novo = new Cliente(clienteDTO.getNome(), clienteDTO.getCpf(),
                clienteDTO.getEmail());
        return clienteRepository.save(novo);
    }

    @Override
    public Cliente buscarPorId(Integer id) {
        return clienteRepository.
                findById(id).orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado!"));

    }

    @Override
    public Cliente buscarPorCpf(String cpf) {

        return clienteRepository.findByCpf(cpf);
    }

    @Override
    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }


    @Override
    public Cliente atualizarBody(ClienteUpdateDTO clienteDTO) {
        return clienteRepository.
                findById(clienteDTO.getId())
                .map(clienteAchado -> {
                    clienteAchado.setNome(clienteDTO.getNome());
                    clienteAchado.setCpf(clienteDTO.getCpf());
                    clienteAchado.setEmail(clienteDTO.getEmail());
                    return clienteRepository.save(clienteAchado);
                })
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado para atualizar!"));

    }

    @Override
    public void deletarporId(Integer id) {
        clienteRepository.
                findById(id)
                .map(cliente -> {
                    clienteRepository.delete(cliente);
                    return Void.TYPE;
                })
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado para deletar!"));

    }


}
