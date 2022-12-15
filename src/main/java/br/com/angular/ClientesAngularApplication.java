package br.com.angular;

import br.com.angular.model.entity.Usuario;
import br.com.angular.service.UsuarioService;
import br.com.angular.service.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class ClientesAngularApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientesAngularApplication.class, args);
    }


    @Bean
    public CommandLineRunner executar(@Autowired UsuarioServiceImpl usuarioService) {
        return args -> {
            String[] permissao = {"USER", "ADMIN"};

            Set<String> roles = new HashSet<String>();
            roles.add("USER");
            roles.add("ADMIN");

            Usuario user = new Usuario("user", "user", roles);
            Usuario salvo = usuarioService.salvar(user);
            System.out.println(salvo.toString());


        };
    }

}
