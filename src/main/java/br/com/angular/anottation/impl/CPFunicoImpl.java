package br.com.angular.anottation.impl;

import br.com.angular.anottation.CPFunico;
import br.com.angular.service.impl.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CPFunicoImpl implements ConstraintValidator<CPFunico, String> {

    @Autowired
    private ClienteServiceImpl clienteService;

    @Override
    public boolean isValid(String cpf, ConstraintValidatorContext context) {
        return clienteService.buscarPorCpf(cpf) == null;
    }
}
