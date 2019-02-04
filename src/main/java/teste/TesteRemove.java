package teste;

import br.com.startmeup.financas.models.Conta;
import br.com.startmeup.financas.util.JPAUtil;

import javax.persistence.EntityManager;

public class TesteRemove {
    public static void main(String[] args) {
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
        Conta conta = em.find(Conta.class, (long)1);
        em.remove(conta);
        em.getTransaction().commit();
        em.close();
    }
}
