package teste;

import br.com.startmeup.financas.models.Categoria;
import br.com.startmeup.financas.models.Conta;
import br.com.startmeup.financas.models.Movimentacao;
import br.com.startmeup.financas.models.TipoMovimentacao;
import br.com.startmeup.financas.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class TestJPQLCategoria {
    public static void main(String[] args) {
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        Categoria categoria = new Categoria();
        categoria.setId(1);

        String jpgl = "SELECT m FROM Movimentacao m JOIN m.categorias c WHERE c = :pCategoria";
        Query query = em.createQuery(jpgl);
        query.setParameter("pCategoria", categoria);

        List<Movimentacao> resultados = query.getResultList();
        for (Movimentacao mv: resultados) {
            System.out.println("Descricao: "+ mv.getDescricao());
            System.out.println("Conta_id: "+ mv.getConta().getId());
        }

        em.close();
    }
}
