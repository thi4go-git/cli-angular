package br.com.angular.model.repository;

import br.com.angular.model.entity.ServicoPrestado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ServicoPrestadoRepository extends JpaRepository<ServicoPrestado, Integer> {

    @Query(" select serv from ServicoPrestado serv join serv.cliente cli " +
            " where upper( cli.nome ) like upper ( :nome ) and MONTH(serv.dataServico) =:mes ")
    List<ServicoPrestado> listarPorNomeClienteEMes(
            @Param("nome") String nome, @Param("mes") Integer mes);

}
