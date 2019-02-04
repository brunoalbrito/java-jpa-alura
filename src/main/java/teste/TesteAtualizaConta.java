package teste;

import br.com.startmeup.financas.models.Conta;
import br.com.startmeup.financas.util.JPAUtil;

import javax.persistence.EntityManager;

public class TesteAtualizaConta {
    public static void main(String[] args) {
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
        Conta conta = new Conta();
        conta.setId(1);
        conta.setTitular("Bruno");
        em.merge(conta);
        em.getTransaction().commit();;

        em.close();
    }
}
