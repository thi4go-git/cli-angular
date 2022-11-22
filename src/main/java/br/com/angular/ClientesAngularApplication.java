package br.com.angular;

import br.com.angular.model.entity.Usuario;
import br.com.angular.service.UsuarioService;
import br.com.angular.service.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClientesAngularApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientesAngularApplication.class, args);
    }


    @Bean
    public CommandLineRunner executar(@Autowired UsuarioServiceImpl usuarioService) {
        return args -> {
            String[] permissao = {"USER", "ADMIN"};
            Usuario user = new Usuario("user", "user", permissao);
            System.out.println(usuarioService.salvar(user).toString());
        };
    }

}
