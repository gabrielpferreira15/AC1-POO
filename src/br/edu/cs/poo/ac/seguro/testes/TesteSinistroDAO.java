package br.edu.cs.poo.ac.seguro.testes;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import br.edu.cs.poo.ac.seguro.daos.SinistroDAO;
import br.edu.cs.poo.ac.seguro.entidades.Sinistro;
import br.edu.cs.poo.ac.seguro.entidades.TipoSinistro;

public class TesteSinistroDAO extends TesteDAO {
    private SinistroDAO dao = new SinistroDAO();

    @Override
    protected Class getClasse() {
        return Sinistro.class;
    }

    private Sinistro instanciarSinistro(String numero) {
        Sinistro s = new Sinistro(null, LocalDateTime.now(), LocalDateTime.now(), "admin", BigDecimal.ZERO, TipoSinistro.COLISAO);
        s.setNumero(numero);
        return s;
    }

    @Test
    public void teste01() {
        String numero = "00000000";
        Sinistro s = instanciarSinistro(numero);
        cadastro.incluir(s, numero);
        Sinistro res = dao.buscar(numero);
        Assertions.assertNotNull(res);
    }

    @Test
    public void teste02() {
        String numero = "10000000";
        Sinistro s = instanciarSinistro(numero);
        cadastro.incluir(s, numero);
        Sinistro res = dao.buscar("11000000");
        Assertions.assertNull(res);
    }

    @Test
    public void teste03() {
        String numero = "20000000";
        Sinistro s = instanciarSinistro(numero);
        cadastro.incluir(s, numero);
        boolean ret = dao.excluir(numero);
        Assertions.assertTrue(ret);
    }

    @Test
    public void teste04() {
        String numero = "30000000";
        Sinistro s = instanciarSinistro(numero);
        cadastro.incluir(s, numero);
        boolean ret = dao.excluir("31000000");
        Assertions.assertFalse(ret);
    }

    @Test
    public void teste05() {
        String numero = "40000000";
        Sinistro s = instanciarSinistro(numero);
        boolean ret = dao.incluir(s);
        Assertions.assertTrue(ret);
        Sinistro res = dao.buscar(numero);
        Assertions.assertNotNull(res);
    }

    @Test
    public void teste06() {
        String numero = "50000000";
        Sinistro s = instanciarSinistro(numero);
        cadastro.incluir(s, numero);
        boolean ret = dao.incluir(s);
        Assertions.assertFalse(ret);
    }

    @Test
    public void teste07() {
        String numero = "60000000";
        Sinistro s = instanciarSinistro(numero);
        boolean ret = dao.alterar(s);
        Assertions.assertFalse(ret);
        Sinistro res = dao.buscar(numero);
        Assertions.assertNull(res);
    }

    @Test
    public void teste08() {
        String numero = "70000000";
        Sinistro s = instanciarSinistro(numero);
        cadastro.incluir(s, numero);
        Sinistro sNovo = instanciarSinistro(numero);
        boolean ret = dao.alterar(sNovo);
        Assertions.assertTrue(ret);
    }
}