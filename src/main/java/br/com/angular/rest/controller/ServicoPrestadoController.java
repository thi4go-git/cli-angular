package br.com.angular.rest.controller;

import br.com.angular.model.entity.ServicoPrestado;
import br.com.angular.rest.dto.ServicoPrestadoDTO;
import br.com.angular.service.impl.ServicoPrestadoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/servicos-prestados")
public class ServicoPrestadoController {

    @Autowired
    private ServicoPrestadoServiceImpl servicoPrestadoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ServicoPrestado salvar(@RequestBody @Valid ServicoPrestadoDTO dto) {
        return servicoPrestadoService.salvar(dto);
    }

    @GetMapping
    public List<ServicoPrestadoDTO> listarTodos() {
        List<ServicoPrestadoDTO> listaServicoPrestadoDTO = new ArrayList<>();

        for (ServicoPrestado servico : servicoPrestadoService.listarTodos()) {
            ServicoPrestadoDTO dtoNovo = new ServicoPrestadoDTO();
            dtoNovo.setId(servico.getId());
            dtoNovo.setDescricao(servico.getDescricao());
            dtoNovo.setValor("" + servico.getValor());
            dtoNovo.setData(servico.getDataServico());
            dtoNovo.setIdCliente(servico.getCliente().getId());

            listaServicoPrestadoDTO.add(dtoNovo);

        }

        return listaServicoPrestadoDTO;
    }


    @GetMapping("/filtro-parametros")
    public List<ServicoPrestadoDTO> listarPorParametros(
            @RequestParam(value = "nome", required = false, defaultValue = "") String nome,
            @RequestParam(value = "mes", required = false, defaultValue = "") Integer mes
    ) {


        List<ServicoPrestadoDTO> listaServicoPrestadoDTO = new ArrayList<>();

        for (ServicoPrestado servico : servicoPrestadoService.listarPorNomeClienteEMes(nome, mes)) {
            ServicoPrestadoDTO dtoNovo = new ServicoPrestadoDTO();
            dtoNovo.setId(servico.getId());
            dtoNovo.setDescricao(servico.getDescricao());
            dtoNovo.setValor("" + servico.getValor());
            dtoNovo.setData(servico.getDataServico());
            dtoNovo.setIdCliente(servico.getCliente().getId());

            listaServicoPrestadoDTO.add(dtoNovo);

        }

        return listaServicoPrestadoDTO;

    }


}
