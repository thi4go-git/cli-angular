package br.com.angular.rest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ServicoPrestadoDTO {

    private Integer id;

    @NotNull(message = "{campo.descricao.obrigatorio}")
    private String descricao;

    @NotNull(message = "{campo.valor.obrigatorio}")
    private String valor;

    @NotNull(message = "{campo.data.obrigatorio}")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;

    @NotNull(message = "{campo.idCliente.obrigatorio}")
    private Integer idCliente;


}
