package br.com.startmeup.financas.models;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

@Data
@Entity
@NamedQuery(query="SELECT AVG(m.valor) FROM Movimentacao m WHERE m.conta = :pConta" +
        " AND m.tipo = :pTipo GROUP BY m.data ",name = "MediasPorDiaETipo")
public class Movimentacao {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private BigDecimal valor;

    @Enumerated
    private TipoMovimentacao tipo;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar data;

    private String descricao;

    @ManyToOne
    private Conta conta;


    @ManyToMany
    private List<Categoria> categorias;
}
