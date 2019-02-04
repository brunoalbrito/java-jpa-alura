package teste;

import br.com.startmeup.financas.models.Categoria;
import br.com.startmeup.financas.models.Conta;
import br.com.startmeup.financas.models.Movimentacao;
import br.com.startmeup.financas.models.TipoMovimentacao;
import br.com.startmeup.financas.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

public class TesteMovimentacaoComCategoria {
    public static void main(String[] args) {

        Categoria categoria1 = new Categoria("viagem");

        Categoria categoria2 = new Categoria("negócios");

        Conta conta = new Conta();
        conta.setId(1);

        Movimentacao  movimentacao1 = new Movimentacao();
        movimentacao1.setData(Calendar.getInstance());
        movimentacao1.setDescricao("Viagem a SP");
        movimentacao1.setTipo(TipoMovimentacao.SAIDA);
        movimentacao1.setValor(new BigDecimal("100.00"));
        movimentacao1.setCategorias(Arrays.asList(categoria1, categoria2));

        movimentacao1.setConta(conta);

        Movimentacao  movimentacao2 = new Movimentacao();
        movimentacao2.setData(Calendar.getInstance());
        movimentacao2.setDescricao("Viagem ao RJ");
        movimentacao2.setTipo(TipoMovimentacao.SAIDA);
        movimentacao2.setValor(new BigDecimal("200.00"));
        movimentacao2.setCategorias(Arrays.asList(categoria1, categoria2));

        movimentacao2.setConta(conta);

        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        em.persist(categoria1);
        em.persist(categoria2);

        em.persist(movimentacao1);
        em.persist(movimentacao2);

        em.getTransaction().commit();
    }
}
