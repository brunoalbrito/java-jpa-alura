package teste;

import br.com.startmeup.financas.models.Conta;
import br.com.startmeup.financas.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class TesteTodasAsMovimentacaoDasContas {
    public static void main(String[] args) {
        EntityManager em = new JPAUtil().getEntityManager();

        String jpql = "SELECT DISTINCT c FROM Conta c LEFT JOIN FETCH c.movimentacoes ";
        Query query = em.createQuery(jpql);
        List<Conta> contas = query.getResultList();
        for (Conta c : contas) {
            System.out.println(c.getId());
            System.out.println(c.getMovimentacoes());
        }
        em.close();
    }
}
