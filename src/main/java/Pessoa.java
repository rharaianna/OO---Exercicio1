public class Pessoa {
    private String nome;
    private int idade;
    private float altura;
    private float peso;

    public Pessoa() {
        setIdade(0);
        setAltura(30.0f);
        setPeso(2.0f);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if (idade<0){
            throw new IllegalArgumentException("Idade deve ser maior ou igual a 0");
        }
        this.idade = idade;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float centimetros) {
        if (centimetros<30){
            throw new IllegalArgumentException("Altura deve ser maior ou igual a 30cm");
        }
        this.altura = centimetros;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float quilos) {
        if (quilos<2){
            throw new IllegalArgumentException("Peso deve ser maior ou igual a 2kg");
        }
        this.peso = quilos;
    }

    public void envelhecer(){
        setIdade(getIdade()+1);
    }

    public void crescer(float centimetros){
        if(idade>=21){
            throw new IllegalArgumentException("Idade deve ser menor a 21 para crescer");
        }
        setAltura(getAltura()+centimetros);
    }

    public void alterar_peso(float quilos, boolean ganhar) {
        if (quilos <= 0) {
            throw new IllegalArgumentException("Quilo deve ser maior que 0");
        }
        if (ganhar) {
            setPeso(getPeso() + quilos);
        } else {
            setPeso(getPeso() - quilos);
        }
    }

    public void ganhar_peso(float quilos) {
        alterar_peso(quilos, true);
    }

    public void perder_peso(float quilos) {
        alterar_peso(quilos, false);
    }
}
