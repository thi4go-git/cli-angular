package br.com.angular.model.repository;

import br.com.angular.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    Cliente findByCpf(String cpf);
}
