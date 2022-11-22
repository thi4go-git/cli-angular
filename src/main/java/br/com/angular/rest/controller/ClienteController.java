package br.com.angular.rest.controller;

import br.com.angular.model.entity.Cliente;
import br.com.angular.rest.dto.ClienteDTO;
import br.com.angular.rest.dto.ClienteUpdateDTO;
import br.com.angular.service.impl.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController // Diz que essa classe será uma classe de controle REST
@RequestMapping("/api/clientes")//
public class ClienteController {

    @Autowired
    private ClienteServiceImpl clienteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente salvar(@RequestBody @Valid ClienteDTO clienteDTO) {
        return clienteService.salvar(clienteDTO);
    }


    @GetMapping("{id}") // obtem o id passado atraves da URL através dessa variável 'id'
    public Cliente buscarPorId(@PathVariable Integer id) { // informa a variável que será parametro
        return clienteService.buscarPorId(id);
    }

    @GetMapping
    public List<Cliente> listarTodos() {
        return clienteService.listarTodos();
    }

    @PutMapping()//atualizar por Body
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarPorBody(@RequestBody @Valid ClienteUpdateDTO clienteDTO) {
        clienteService.atualizarBody(clienteDTO);
    }


    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarporId(@PathVariable Integer id) {
        clienteService.deletarporId(id);
    }


}
