package teste;

import br.com.startmeup.financas.models.Conta;
import br.com.startmeup.financas.models.Movimentacao;
import br.com.startmeup.financas.models.TipoMovimentacao;
import br.com.startmeup.financas.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Calendar;

public class TesteMovimentacao {
    public static void main(String[] args) {


        Conta conta = new Conta();
        conta.setAgencia("0102");
        conta.setBanco("Itau");
        conta.setNumero("1234");
        conta.setTitular("Bruno");


        Movimentacao movimentacao = new Movimentacao();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        movimentacao.setData(calendar);
        movimentacao.setDescricao("Churrascaria");
        movimentacao.setTipo(TipoMovimentacao.SAIDA);
        movimentacao.setValor(new BigDecimal(200));
        movimentacao.setConta(conta);

        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
        em.persist(conta);
        em.persist(movimentacao);


        em.getTransaction().commit();
        em.close();

    }
}
