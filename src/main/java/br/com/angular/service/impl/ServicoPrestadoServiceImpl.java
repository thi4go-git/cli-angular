package br.com.angular.service.impl;

import br.com.angular.model.entity.Cliente;
import br.com.angular.model.entity.ServicoPrestado;
import br.com.angular.model.repository.ClienteRepository;
import br.com.angular.model.repository.ServicoPrestadoRepository;
import br.com.angular.rest.dto.ServicoPrestadoDTO;
import br.com.angular.service.ServicoPrestadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Service
public class ServicoPrestadoServiceImpl implements ServicoPrestadoService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ServicoPrestadoRepository servicoPrestadoRepository;

    @Override
    @Transactional
    public ServicoPrestado salvar(ServicoPrestadoDTO servicoPrestadoDTO) {
        LocalDate dataServico = servicoPrestadoDTO.getData();
        Cliente cliente = clienteRepository.
                findById(servicoPrestadoDTO.getIdCliente())
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Cliente não encontrado para Salvar Serviço Prestado!"));
        ServicoPrestado servico = new ServicoPrestado(servicoPrestadoDTO.getDescricao(),
                cliente, new BigDecimal(servicoPrestadoDTO.getValor()), dataServico);
        return servicoPrestadoRepository.save(servico);
    }

    @Override
    public List<ServicoPrestado> listarTodos() {
        return servicoPrestadoRepository.findAll();
    }


    @Override
    public List<ServicoPrestado> listarFiltro(ServicoPrestadoDTO servicoPrestadoDTO) {

        LocalDate dataServico = LocalDate.parse(servicoPrestadoDTO.getData().toString(),
                DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        //
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        //
        ServicoPrestado servico = new ServicoPrestado(servicoPrestadoDTO.getDescricao(),
                new BigDecimal(servicoPrestadoDTO.getValor()), dataServico);
        //
        Example<ServicoPrestado> example = Example.of(servico, matcher);

        return servicoPrestadoRepository.findAll(example);
    }

    @Override
    public List<ServicoPrestado> listarPorNomeClienteEMes(String nome, Integer mes) {
        return servicoPrestadoRepository.listarPorNomeClienteEMes("%" + nome + "%", mes);
    }
}
