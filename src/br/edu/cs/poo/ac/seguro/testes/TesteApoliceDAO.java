package br.edu.cs.poo.ac.seguro.testes;
import java.math.BigDecimal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import br.edu.cs.poo.ac.seguro.daos.ApoliceDAO;
import br.edu.cs.poo.ac.seguro.entidades.Apolice;

public class TesteApoliceDAO extends TesteDAO {
    private ApoliceDAO dao = new ApoliceDAO();

    @Override
    protected Class getClasse() {
        return Apolice.class;
    }

    private Apolice instanciarApolice(String numero) {
        Apolice a = new Apolice(null, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO);
        a.setNumero(numero);
        return a;
    }

    @Test
    public void teste01() {
        String numero = "00000000";
        Apolice a = instanciarApolice(numero);
        cadastro.incluir(a, numero);
        Apolice res = dao.buscar(numero);
        Assertions.assertNotNull(res);
    }

    @Test
    public void teste02() {
        String numero = "10000000";
        Apolice a = instanciarApolice(numero);
        cadastro.incluir(a, numero);
        Apolice res = dao.buscar("11000000");
        Assertions.assertNull(res);
    }

    @Test
    public void teste03() {
        String numero = "20000000";
        Apolice a = instanciarApolice(numero);
        cadastro.incluir(a, numero);
        boolean ret = dao.excluir(numero);
        Assertions.assertTrue(ret);
    }

    @Test
    public void teste04() {
        String numero = "30000000";
        Apolice a = instanciarApolice(numero);
        cadastro.incluir(a, numero);
        boolean ret = dao.excluir("31000000");
        Assertions.assertFalse(ret);
    }

    @Test
    public void teste05() {
        String numero = "40000000";
        Apolice a = instanciarApolice(numero);
        boolean ret = dao.incluir(a);
        Assertions.assertTrue(ret);
        Apolice res = dao.buscar(numero);
        Assertions.assertNotNull(res);
    }

    @Test
    public void teste06() {
        String numero = "50000000";
        Apolice a = instanciarApolice(numero);
        cadastro.incluir(a, numero);
        boolean ret = dao.incluir(a);
        Assertions.assertFalse(ret);
    }

    @Test
    public void teste07() {
        String numero = "60000000";
        Apolice a = instanciarApolice(numero);
        boolean ret = dao.alterar(a);
        Assertions.assertFalse(ret);
        Apolice res = dao.buscar(numero);
        Assertions.assertNull(res);
    }

    @Test
    public void teste08() {
        String numero = "70000000";
        Apolice a = instanciarApolice(numero);
        cadastro.incluir(a, numero);
        Apolice aNova = instanciarApolice(numero);
        boolean ret = dao.alterar(aNova);
        Assertions.assertTrue(ret);
    }
}