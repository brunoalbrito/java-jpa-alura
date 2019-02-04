package teste;

import br.com.startmeup.financas.models.Conta;
import br.com.startmeup.financas.models.TipoMovimentacao;
import br.com.startmeup.financas.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.lang.reflect.Type;
import java.util.List;

public class TesteConsultaFuncaoTypedQuery {
    public static void main(String[] args) {
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        Conta conta = new Conta();
        conta.setId(1);

        String jpgl = "SELECT AVG(m.valor) FROM Movimentacao m WHERE m.conta = :pConta " +
                "AND m.tipo = :pTipo " +
                "GROUP BY DAY(m.data), MONTH(m.data), YEAR(m.data)";
        TypedQuery query =  em.createQuery(jpgl, Double.class);
        query.setParameter("pConta", conta);
        query.setParameter("pTipo", TipoMovimentacao.SAIDA);

        List<Double> result = (List<Double>) query.getResultList();
        System.out.println(result);
        em.close();
    }
}
