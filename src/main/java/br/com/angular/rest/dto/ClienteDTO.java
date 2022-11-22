package br.com.angular.rest.dto;

import br.com.angular.anottation.CPFunico;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

    @NotEmpty(message = "{campo.nome.obrigatorio}")
    private String nome;

    @NotNull(message = "{campo.cpf.obrigatorio}")
    @CPF(message = "{campo.cpf.invalido}")
    @CPFunico
    private String cpf;

    @NotEmpty(message = "{campo.email.obrigatorio}")
    @Email(message = "{campo.email.invalido}")
    private String email;
}
