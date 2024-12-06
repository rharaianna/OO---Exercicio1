public class Funcionario {
    private String nome;
    private String cargo;
    private String departamento;
    private float salario;

    public enum Departamento {
        MARKETING, GP, COMERCIAL, PROJETOS;
    }

    public enum Cargo {
        ASSESSOR, GERENTE, DIRETOR
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        try {
            this.cargo = Cargo.valueOf(cargo.toUpperCase()).name();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Cargo inválido: " + cargo);
        }
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        try {
            this.departamento = Departamento.valueOf(departamento.toUpperCase()).name();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Departamento inválido: " + departamento);
        }
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        if (salario <= 0) {
            throw new IllegalArgumentException("Salário inválido");
        }
        this.salario = salario;
    }

    public void receber_aumento(float porcentagem) {
        if (porcentagem <= 0 || porcentagem >= 1) {
            throw new IllegalArgumentException("Porcentagem não aceita");
        }
        this.salario = (1+ porcentagem)*salario;
    }

    public void mudar_departamento(String departamento) {
        setDepartamento(departamento);
    }

    public String exibir_dados(){
        return "Nome: " + nome + "\n" + "Cargo: " + cargo + "\n" + "Departamento: " + departamento + "\n" + "Salário: R$ " + String.format("%.2f", salario);
    }
}
