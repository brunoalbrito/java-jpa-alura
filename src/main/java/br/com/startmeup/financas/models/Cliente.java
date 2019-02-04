package br.com.startmeup.financas.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    private String profissao;

    private String endereco;


    @JoinColumn(unique = true)
    @OneToOne
    private Conta conta;
}
