package br.com.startmeup.financas.models;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@ToString(exclude = "movimentacoes")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String titular;

    private String numero;

    private String banco;

    private String agencia;

    @OneToMany(mappedBy = "conta")
    private List<Movimentacao> movimentacoes;
}
