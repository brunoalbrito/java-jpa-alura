package teste;

import br.com.startmeup.financas.dao.MovimentacaoDao;
import br.com.startmeup.financas.models.Conta;
import br.com.startmeup.financas.models.TipoMovimentacao;
import br.com.startmeup.financas.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class TesteFuncoesMovimentacaoJPQL {
    public static void main(String[] args) {
        EntityManager em = new JPAUtil().getEntityManager();

        Conta conta = new Conta();
        conta.setId(1);

        em.getTransaction().begin();

//        MovimentacaoDao dao = new MovimentacaoDao(em);

        TypedQuery typedQuery = em.createNamedQuery("MediasPorDiaETipo", Double.class);
        typedQuery.setParameter("pConta", conta);
        typedQuery.setParameter("pTipo", TipoMovimentacao.SAIDA);


//        List<Double> medias = dao.getMediasPorDiaETipo(TipoMovimentacao.SAIDA, conta);

        List<Double> medias = typedQuery.getResultList();

        em.getTransaction().commit();
        em.close();

        for (Double media : medias) {
            System.out.println("A média é: "+media);
        }
    }
}
