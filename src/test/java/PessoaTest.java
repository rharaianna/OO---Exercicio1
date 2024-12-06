import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class PessoaTest {
    @Test
    public void nomeia() {
        Pessoa alguem = new Pessoa();
        alguem.setNome("Alguem");
        assertEquals("Alguem", alguem.getNome());
    }

    @Test
    public void alteraIdadeMenosQueZero() {
        try {
            Pessoa alguem = new Pessoa();
            alguem.setIdade(-1);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Idade deve ser maior ou igual a 0", e.getMessage());
        }
    }

    @Test
    public void alteraAlturaMenosQue30() {
        try {
            Pessoa alguem = new Pessoa();
            alguem.setAltura(29);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Altura deve ser maior ou igual a 30cm", e.getMessage());
        }
    }

    @Test
    public void alteraAlturaMaisVelhoQue21() {
        try {
            Pessoa alguem = new Pessoa();
            alguem.setAltura(30);
            alguem.setIdade(21);
            alguem.crescer(150);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Idade deve ser menor a 21 para crescer", e.getMessage());
        }
    }

    @Test
    public void alteraAlturaMaisNovoQue21() {
        Pessoa alguem = new Pessoa();
        alguem.setAltura(30);
        alguem.setIdade(20);
        alguem.crescer(150);
        assertEquals(180, alguem.getAltura());

    }

    @Test
    public void alteraPesoMenosQue2() {
        try {
            Pessoa alguem = new Pessoa();
            alguem.setPeso(1);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Peso deve ser maior ou igual a 2kg", e.getMessage());
        }
    }

    @Test
    public void ganhaPeso() {
        Pessoa alguem = new Pessoa();
        alguem.ganhar_peso(20);
        assertEquals(22, alguem.getPeso());
    }

    @Test
    public void perdePeso() {
        Pessoa alguem = new Pessoa();
        alguem.ganhar_peso(20);
        alguem.perder_peso(12);
        assertEquals(10, alguem.getPeso());
    }

    @Test
    public void envechece() {
        Pessoa alguem = new Pessoa();
        alguem.envelhecer();
        assertEquals(1, alguem.getIdade());
    }

}
