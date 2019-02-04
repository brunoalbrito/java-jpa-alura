package teste;

import br.com.startmeup.financas.models.Cliente;
import br.com.startmeup.financas.models.Conta;
import br.com.startmeup.financas.util.JPAUtil;

import javax.persistence.EntityManager;

public class TesteContaCliente {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.setNome("Leandro");
        cliente.setEndereco("Rua Qualquer");
        cliente.setProfissao("Professor");


        Conta conta = new Conta();
        conta.setId(1);

        cliente.setConta(conta);


        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        em.persist(cliente);

        em.getTransaction().commit();
    }
}
