import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


public class LivroTest {

    @Test
    public void criarTituloLivro() {
        Livro novoLivro = new Livro(1900, 20);
        novoLivro.setTitulo("livro");
        assertEquals("livro", novoLivro.getTitulo());
    }

    @Test
    public void criarAutorLivro() {
        Livro novoLivro = new Livro(1900, 20);
        novoLivro.setAutor("autor");
        assertEquals("autor", novoLivro.getAutor());
    }

    @Test
    public void criarGeneroLivro() {
        Livro novoLivro = new Livro(1900, 20);
        novoLivro.setGenero("genero");
        assertEquals("genero", novoLivro.getGenero());
    }

    @Test
    public void anoImpossivel() {
        try {
            Livro novoLivro = new Livro(1900, 20);
            novoLivro.setAno_publicacao(2025);
        } catch (IllegalArgumentException e) {
            assertEquals("não existe livro publicado no futuro", e.getMessage());
        }
    }

    @Test
    public void numeroPaginasImpossivel() {
        try {
            Livro novoLivro = new Livro(1900, 20);
            novoLivro.setNumero_paginas(0);
        } catch (IllegalArgumentException e) {
            assertEquals("não é possivel", e.getMessage());
        }
    }

    @Test
    public void abrirAbertoInicio() {
        try {
            Livro novoLivro = new Livro(1900, 20);
            novoLivro.abrir();
        } catch (IllegalArgumentException e) {
            assertEquals("O livro já está aberto", e.getMessage());
        }
    }

    @Test
    public void fecharAberto() {
        try {
            Livro novoLivro = new Livro(1900, 20);
            novoLivro.abrir();
            novoLivro.fechar();
        } catch (IllegalArgumentException e) {
            assertEquals("fechar Livro", e.getMessage());
        }
    }

    @Test
    public void abrirFechado() {
        try {
            Livro novoLivro = new Livro(1900, 20);
        } catch (IllegalArgumentException e) {
            assertEquals("Abrir Livro", e.getMessage());
        }
    }

    @Test
    public void fecharFechado() {
        try {
            Livro novoLivro = new Livro(1900, 20);
            novoLivro.fechar();
        } catch (IllegalArgumentException e) {
            assertEquals("O livro já está fechado", e.getMessage());
        }
    }

    @Test
    public void abreNaPaginaMarcada() {
        Livro novoLivro = new Livro(1900, 20);
        novoLivro.setPagina_atual(10);
        novoLivro.marcar_pagina();
        novoLivro.fechar();
        novoLivro.abrir();
        assertEquals(10, novoLivro.getPagina_atual());
    }

    @Test
    public void marcaPagina() {
        Livro novoLivro = new Livro(1900, 20);
        novoLivro.setPagina_atual(10);
        novoLivro.marcar_pagina();
        assertEquals(10, novoLivro.getPagina_marcada());
    }

    @Test
    public void marcarCapa(){
        try {
            Livro novoLivro = new Livro(1900, 20);
            novoLivro.marcar_pagina();
        }
        catch (IllegalArgumentException e) {
            assertEquals("não pode marcar a capa", e.getMessage());
        }
    }

    @Test
    public void avança() {
        Livro novoLivro = new Livro(1900, 20);
        novoLivro.setPagina_atual(20);
        novoLivro.avancar_pagina();
        assertEquals(21, novoLivro.getPagina_atual());
    }

    @Test
    public void avançaContracapa() {
        try {
            Livro novoLivro = new Livro(1900, 20);
            novoLivro.setPagina_atual(21);
            novoLivro.avancar_pagina();
        } catch (IllegalArgumentException e) {
            assertEquals("Já está na contracapa", e.getMessage());
        }
    }

    @Test
    public void retrocede() {
        Livro novoLivro = new Livro(1900, 20);
        novoLivro.setPagina_atual(1);
        novoLivro.retroceder_pagina();
        assertEquals(0, novoLivro.getPagina_atual());
    }

    @Test
    public void retrocedeCapa() {
        try {
            Livro novoLivro = new Livro(1900, 20);
            novoLivro.retroceder_pagina();
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Já está na capa", e.getMessage());
        }
    }
}
