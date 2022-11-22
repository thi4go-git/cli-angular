package br.com.angular.model.entity;

import br.com.angular.rest.dto.ServicoPrestadoDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class ServicoPrestado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @Column
    private BigDecimal valor;

    @Column(length = 100, updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataServico;

    public ServicoPrestado(String descricao, Cliente cliente, BigDecimal valor, LocalDate dataServico) {
        this.descricao = descricao;
        this.cliente = cliente;
        this.valor = valor;
        this.dataServico = dataServico;
    }

    public ServicoPrestado(String descricao, BigDecimal valor, LocalDate dataServico) {
        this.descricao = descricao;
        this.valor = valor;
        this.dataServico = dataServico;
    }

}
