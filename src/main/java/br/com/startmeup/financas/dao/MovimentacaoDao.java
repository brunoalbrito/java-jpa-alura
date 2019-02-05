package br.com.startmeup.financas.dao;

import br.com.startmeup.financas.models.Conta;
import br.com.startmeup.financas.models.TipoMovimentacao;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class MovimentacaoDao {

    private EntityManager em;

    public MovimentacaoDao(EntityManager em){
        this.em = em;
    }

    public List<Double> getMediasPorDiaETipo(TipoMovimentacao saida, Conta conta) {

        String jpgl = "SELECT AVG(m.valor) FROM Movimentacao m WHERE m.conta = :pConta " +
                "AND m.tipo = :pTipo GROUP BY m.data " ;
        TypedQuery query =  em.createQuery(jpgl, Double.class);
        query.setParameter("pConta", conta);
        query.setParameter("pTipo", TipoMovimentacao.SAIDA);

        return query.getResultList();
    }
}
