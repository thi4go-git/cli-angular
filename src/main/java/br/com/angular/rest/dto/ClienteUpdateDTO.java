package br.com.angular.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteUpdateDTO {
    private Integer id;

    @NotEmpty(message = "{campo.nome.obrigatorio}")
    private String nome;

    @NotNull(message = "{campo.cpf.obrigatorio}")
    @CPF(message = "{campo.cpf.invalido}")
    private String cpf;

    @NotEmpty(message = "{campo.email.obrigatorio}")
    private String email;


    private String dataCadastro;
}
