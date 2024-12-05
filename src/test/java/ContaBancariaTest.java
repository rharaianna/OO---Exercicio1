import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ContaBancariaTest {

    @Test
    void tiraMaisDoQueTem() {
        try {
            ContaBancaria conta = new ContaBancaria("12345678");
            conta.depositar(99);
            conta.sacar(100);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Saldo insuficiente", e.getMessage(),
                    "A mensagem da exceção está incorreta.");
        }
    }

    @Test
    void tiraIgualDoQueTem() {
            ContaBancaria conta = new ContaBancaria("12345678");
            conta.depositar(100);
            conta.sacar(100);
            assertEquals(0, conta.getSaldo());
    }

    @Test
    void saqueMenorQueZero() {
        try {
            ContaBancaria conta = new ContaBancaria("12345678");
            conta.sacar(-1);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Valor de saque não pode ser negativo", e.getMessage());
        }
    }

    @Test
    void depositoMenorQueZero() {
        try {
            ContaBancaria conta = new ContaBancaria("12345678");
            conta.depositar(-1);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Valor de depósito não pode ser negativo", e.getMessage());
        }
    }

    @Test
    void deveSomarDeposito(){
        ContaBancaria conta = new ContaBancaria("12345678");
        conta.depositar(100);
        conta.depositar(90);
        assertEquals(190, conta.getSaldo());
    }

    @Test
    void deveRetirarSaque(){
        ContaBancaria conta = new ContaBancaria("12345678");
        conta.depositar(100);
        conta.sacar(90);
        assertEquals(10, conta.getSaldo());
    }

    @Test
    void deveTerOitoDigitos(){
        ContaBancaria conta = new ContaBancaria("12345678");
        conta.setNumero_conta("12345678");
        assertEquals("12345678", conta.getNumero_conta());
    }

    @Test
    void tentaNoveDigitos(){
        try{
            ContaBancaria conta = new ContaBancaria("12345678");
            conta.setNumero_conta("123456789");
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("O número da conta deve ter exatamente 8 caracteres", e.getMessage());
        }
    }

    @Test
    void tentaSeteDigitos() {
        try{
            ContaBancaria conta = new ContaBancaria("12345678");
            conta.setNumero_conta("1234567");
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("O número da conta deve ter exatamente 8 caracteres", e.getMessage());
        }
    }
}

