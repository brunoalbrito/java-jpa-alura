package teste;

import br.com.startmeup.financas.models.Categoria;
import br.com.startmeup.financas.models.Conta;
import br.com.startmeup.financas.models.Movimentacao;
import br.com.startmeup.financas.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class TesteMovimentacaoConta {
    public static void main(String[] args) {
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        Movimentacao movimentacao = em.find(Movimentacao.class, new Long(1));
        Conta conta = movimentacao.getConta();

        System.out.println(conta.getTitular());
        System.out.println(conta.getMovimentacoes().size());


        em.close();
    }
}
