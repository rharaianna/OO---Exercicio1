import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


public class FuncionarioTest {
    @Test
    public void nomeia() {
        Funcionario novato = new Funcionario();
        novato.setNome("novato");
        assertEquals("novato", novato.getNome());
    }

    @Test
    public void atribuiCargoExistente() {
        Funcionario novato = new Funcionario();
        novato.setCargo("assessor");
        assertEquals("ASSESSOR", novato.getCargo());
    }

    @Test
    public void atribuiCargoInexistente() {
        try {
            Funcionario novato = new Funcionario();
            novato.setCargo("vice");
            fail();
        }
        catch (Exception e) {
            assertEquals("Cargo inválido: vice", e.getMessage());
        }


    }

    @Test
    public void atribuiDepartamentoExistente() {
        Funcionario novato = new Funcionario();
        novato.setDepartamento("marketing");
        assertEquals("MARKETING", novato.getDepartamento());
    }

    @Test
    public void atribuiDepartamentoInexistente() {
        try {
            Funcionario novato = new Funcionario();
            novato.setDepartamento("presidencia");
            fail();
        }
        catch (Exception e) {
            assertEquals("Departamento inválido: presidencia", e.getMessage());
        }
    }

    @Test
    public void atribuiSalarioPossivel(){
        Funcionario novato = new Funcionario();
        novato.setSalario(100.00f);
        assertEquals(100.00, novato.getSalario());
    }

    @Test
    public void atribuiSalarioImossivel(){
        try{
            Funcionario novato = new Funcionario();
            novato.setSalario(0.00f);
            fail();
        }
        catch (Exception e) {
            assertEquals("Salário inválido", e.getMessage());
        }
    }

    @Test
    public void atribuiAumentoPossivel(){
        Funcionario novato = new Funcionario();
        novato.setSalario(100.00f);
        novato.receber_aumento(0.10f);
        assertEquals(110.00, novato.getSalario());
    }

    @Test
    public void atribuiAumentoImossivelMenorIgualQue0(){
        try{
            Funcionario novato = new Funcionario();
            novato.setSalario(100.00f);
            novato.receber_aumento(0.00f);
            fail();
        }
        catch (Exception e) {
            assertEquals("Porcentagem não aceita", e.getMessage());
        }
    }

    @Test
    public void atribuiAumentoImossivelMaiorQue1(){
        try{
            Funcionario novato = new Funcionario();
            novato.setSalario(100.00f);
            novato.receber_aumento(1.00f);
            fail();
        }
        catch (Exception e) {
            assertEquals("Porcentagem não aceita", e.getMessage());
        }
    }

    @Test
    public void exibeDadosCorretos(){
        Funcionario novato = new Funcionario();
        novato.setNome("novato");
        novato.setCargo("assessor");
        novato.setDepartamento("marketing");
        novato.setSalario(100.00f);

        String esperado = "Nome: novato\n" +
                "Cargo: ASSESSOR\n" +
                "Departamento: MARKETING\n" +
                "Salário: R$ 100,00";


        assertEquals(esperado, novato.exibir_dados());


    }
}
