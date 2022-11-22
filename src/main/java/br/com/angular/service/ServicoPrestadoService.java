package br.com.angular.service;

import br.com.angular.model.entity.ServicoPrestado;
import br.com.angular.rest.dto.ServicoPrestadoDTO;


import java.util.List;

public interface ServicoPrestadoService {
    ServicoPrestado salvar(ServicoPrestadoDTO servicoPrestadoDTO);

    List<ServicoPrestado> listarTodos();

    List<ServicoPrestado> listarFiltro(ServicoPrestadoDTO servicoPrestadoDTO);

    List<ServicoPrestado> listarPorNomeClienteEMes(String nome, Integer mes);

}
