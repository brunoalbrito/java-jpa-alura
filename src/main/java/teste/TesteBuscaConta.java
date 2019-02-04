package teste;


import br.com.startmeup.financas.models.Conta;
import br.com.startmeup.financas.util.JPAUtil;

import javax.persistence.EntityManager;

public class TesteBuscaConta {
    public static void main(String[] args) {
        EntityManager em = new JPAUtil().getEntityManager();

        em.getTransaction().begin();
        long id = 1;
        Conta conta = em.find(Conta.class,id);
        System.out.println(conta);
        em.getTransaction().commit();
        em.close();
    }
}
