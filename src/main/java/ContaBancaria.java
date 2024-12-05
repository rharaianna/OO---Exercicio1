public class ContaBancaria {

    private String titular;
    private String numero_conta;
    private double saldo;

    public ContaBancaria (String numero_conta) {
        this.saldo = 0;
        this.setNumero_conta(numero_conta);
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }
    public String getNumero_conta() {
        return numero_conta;
    }
    public void setNumero_conta(String numero_conta) {
        if (numero_conta.length() != 8) {
            throw new IllegalArgumentException("O número da conta deve ter exatamente 8 caracteres");
        }
        else {
            this.numero_conta = numero_conta;
        }
    }
    public double getSaldo() {
        return saldo;
    }
    private void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public void depositar (double valor) {
        if (valor < 0){
            throw new IllegalArgumentException("Valor de depósito não pode ser negativo");
        }
        this.saldo += valor;
    }
    public void sacar (double valor) {
        if (valor >= 0){
            if (this.saldo >= valor) {
                this.saldo -= valor;
            }
            else {
                throw new IllegalArgumentException("Saldo insuficiente");
            }
        }
        else {
            throw new IllegalArgumentException("Valor de saque não pode ser negativo");
        }
    }
}
