package br.com.angular.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column
    private String[] permissao;//  = {"USER", "ADMIN"};

    public Usuario(String username, String password, String[] permissao) {
        this.username = username;
        this.password = password;
        this.permissao = permissao;
    }

}
