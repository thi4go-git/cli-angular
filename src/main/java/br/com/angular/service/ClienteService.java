package br.com.angular.service;


import br.com.angular.model.entity.Cliente;
import br.com.angular.rest.dto.ClienteDTO;
import br.com.angular.rest.dto.ClienteUpdateDTO;

import java.util.List;

public interface ClienteService {
    Cliente salvar(ClienteDTO clienteDTO);

    Cliente buscarPorId(Integer id);

    Cliente buscarPorCpf(String cpf);

    List<Cliente> listarTodos();

    Cliente atualizarBody(ClienteUpdateDTO clienteDTO);

    void deletarporId(Integer id);
}
