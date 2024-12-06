public class Produto {
    private String nome;
    private float preco;
    private int quantidade_estoque;
    private String categoria;

    public Produto() {
        preco = 0;
        quantidade_estoque = 0;
    }

    public enum Categoria {
        ROUPA, HIGIENE, FARMÁCIA, COMIDA;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        if (preco < 0) {
            throw new IllegalArgumentException("não pode ser negativo");
        }
        this.preco = preco;
    }

    public int getQuantidade_estoque() {
        return quantidade_estoque;
    }

    public void setQuantidade_estoque(int quantidade) {
        editar_estoque(quantidade, 2);
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        try {
            this.categoria = Categoria.valueOf(categoria.toUpperCase()).name();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Categoria inválida: " + categoria);
        }
    }

    private void editar_estoque(int quantidade, int operacao) {
        if (quantidade < 0){
            throw new IllegalArgumentException("Quantidade deve ser maior ou igual a zero");
        }
        if (operacao==0){
            this.quantidade_estoque += quantidade;
        }
        else if (operacao==1){
            this.quantidade_estoque -= quantidade;
        }
        else if (operacao==2){
            this.quantidade_estoque = quantidade;
        }
    }

    public void adicionar_estoque(int quantidade) {
        editar_estoque(quantidade, 0);
    }

    public void remover_estoque(int quantidade) {
        if (quantidade > quantidade_estoque){
            throw new IllegalArgumentException("Quantidade deve ser menor que estoque");
        }
        editar_estoque(quantidade, 1);
    }

    public void aplicar_desconto(float porcentagem) {
        if (porcentagem <= 0 || porcentagem >=1){
            throw new IllegalArgumentException("Quantidade deve ser maior que zero e menor que 1");
        }
        setPreco(preco - preco*porcentagem);
    }

}
