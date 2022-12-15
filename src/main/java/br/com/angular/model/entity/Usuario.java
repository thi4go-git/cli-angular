package br.com.angular.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

//    @Column
//    private String[] permissao;//  = {"USER", "ADMIN"};


    @ElementCollection(targetClass = String.class)
    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "usuario_permissao",
            uniqueConstraints = {@UniqueConstraint(columnNames = {"usuario", "permissao"})},
            joinColumns = @JoinColumn(name = "usuario")
    )
    @Column(name = "permissao", length = 50)
    private Set<String> permissao = new HashSet<String>();


    public Usuario(String username, String password, Set<String> permissao) {
        this.username = username;
        this.password = password;
        this.permissao = permissao;
    }

}
