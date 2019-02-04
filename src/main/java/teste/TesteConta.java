package teste;

import br.com.startmeup.financas.models.Conta;
import br.com.startmeup.financas.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteConta {
    public static void main(String[] args) {
        EntityManager em = new JPAUtil().getEntityManager();

        Conta conta = new Conta();
        conta.setTitular("Bruno");
        conta.setNumero("123456");
        conta.setBanco("Itau");
        conta.setAgencia("CaucaiaDoAlto");

        em.getTransaction().begin();
        em.persist(conta);
        em.getTransaction().commit();
        em.close();
    }
}
