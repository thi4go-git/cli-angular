package br.com.angular.anottation;


import br.com.angular.anottation.impl.CPFunicoImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CPFunicoImpl.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CPFunico {

    String message() default "Já existe um Cliente cadastrado com o CPF informado";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
