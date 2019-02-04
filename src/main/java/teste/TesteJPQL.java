package teste;

import br.com.startmeup.financas.models.Conta;
import br.com.startmeup.financas.models.Movimentacao;
import br.com.startmeup.financas.models.TipoMovimentacao;
import br.com.startmeup.financas.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class TesteJPQL {
    public static void main(String[] args) {
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        Conta conta = new Conta();
        conta.setId(1);

        String jpgl = "SELECT m FROM Movimentacao m WHERE m.conta = :pConta " +
                "AND m.tipo = :pTipo " +
                "ORDER BY m.valor DESC";
        Query query =  em.createQuery(jpgl);
        query.setParameter("pConta", conta);
        query.setParameter("pTipo", TipoMovimentacao.SAIDA);

        List<Movimentacao> resultados = query.getResultList();
        for (Movimentacao mv: resultados) {
            System.out.println("Descricao: "+ mv.getDescricao());
            System.out.println("Conta_id: "+ mv.getConta().getId());
        }

        em.close();
    }
}
