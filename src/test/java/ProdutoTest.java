import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


public class ProdutoTest {
    @Test
    public void nomeia() {
        Produto produto = new Produto();
        produto.setNome("Produto 1");
        assertEquals("Produto 1", produto.getNome());
    }

    @Test
    public void precoCorreto() {
        Produto produto = new Produto();
        produto.setPreco(10.00f);
        assertEquals(10.00f, produto.getPreco());
    }

    @Test
    public void precoIncorreto() {
        try {
            Produto produto = new Produto();
            produto.setPreco(-10.00f);
            fail();
        }
        catch (Exception e) {
            assertEquals("não pode ser negativo", e.getMessage());
        }
    }

    @Test
    public void valorEstoqueCorreto() {
        Produto produto = new Produto();
        produto.setQuantidade_estoque(10);
        assertEquals(10, produto.getQuantidade_estoque());
    }

    @Test
    public void valorEstoqueIncorreto() {
        try {
            Produto produto = new Produto();
            produto.setQuantidade_estoque(-1);
            fail();
        }
        catch (Exception e) {
            assertEquals("Quantidade deve ser maior ou igual a zero", e.getMessage());
        }
    }

    @Test
    public void removerEstoqueCorreto() {
        Produto produto = new Produto();
        produto.setQuantidade_estoque(10);
        produto.remover_estoque(1);
        assertEquals(9, produto.getQuantidade_estoque());
    }

    @Test
    public void removeMaisQueTem(){
        try {
            Produto produto = new Produto();
            produto.setQuantidade_estoque(10);
            produto.remover_estoque(11);
            fail();
        }
        catch (Exception e) {
            assertEquals("Quantidade deve ser menor que estoque", e.getMessage());
        }
    }

    @Test
    public void adicionarEstoqueCorreto() {
        Produto produto = new Produto();
        produto.setQuantidade_estoque(10);
        produto.adicionar_estoque(1);
        assertEquals(11, produto.getQuantidade_estoque());
    }

    @Test
    public void categoriaExistente() {
        Produto produto = new Produto();
        produto.setCategoria("roupa");
        assertEquals("ROUPA", produto.getCategoria());
    }

    @Test
    public void categoriaInexistente() {
        try {
            Produto produto = new Produto();
            produto.setCategoria("aaaa");
            fail();
        }
        catch (Exception e) {
            assertEquals("Categoria inválida: aaaa", e.getMessage());
        }
    }

    @Test
    public void descontoCorreto() {
        Produto produto = new Produto();
        produto.setPreco(100.00f);
        produto.aplicar_desconto(0.10f);
        assertEquals(90.00f, produto.getPreco());
    }

    @Test
    public void descontoIncorretoUm() {
        try{
            Produto produto = new Produto();
            produto.setPreco(100.00f);
            produto.aplicar_desconto(1.00f);
            fail();
        }
        catch (Exception e) {
            assertEquals("Quantidade deve ser maior que zero e menor que 1", e.getMessage());
        }
    }

    @Test
    public void descontoIncorretoMenosUm() {
        try{
            Produto produto = new Produto();
            produto.setPreco(100.00f);
            produto.aplicar_desconto(-1.00f);
            fail();
        }
        catch (Exception e) {
            assertEquals("Quantidade deve ser maior que zero e menor que 1", e.getMessage());
        }
    }
}
