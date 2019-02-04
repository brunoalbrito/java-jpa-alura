package teste;

import br.com.startmeup.financas.models.Conta;
import br.com.startmeup.financas.models.TipoMovimentacao;
import br.com.startmeup.financas.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigDecimal;

public class TesteConsultaFuncaoCount {
    public static void main(String[] args) {
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        Conta conta = new Conta();
        conta.setId(1);

        String jpgl = "SELECT COUNT(m.valor) FROM Movimentacao m WHERE m.conta = :pConta " +
                "AND m.tipo = :pTipo " +
                "ORDER BY m.valor DESC";
        Query query =  em.createQuery(jpgl);
        query.setParameter("pConta", conta);
        query.setParameter("pTipo", TipoMovimentacao.SAIDA);

        Long result = (Long) query.getSingleResult();
        System.out.println("Quantidade de Movimentacoes: "+ result);
        em.close();
    }
}
