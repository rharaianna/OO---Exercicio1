

public class Livro {
    private String titulo;
    private String autor;
    private String genero;
    private int ano_publicacao;
    private int numero_paginas;
    private int pagina_atual;
    private int pagina_marcada;


    public Livro(int ano_publicacao,int numero_paginas) {
        this.setAno_publicacao(ano_publicacao);
        this.setNumero_paginas(numero_paginas);
        this.pagina_marcada=-1;
        this.pagina_atual = 0;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }


    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }


    public int getAno_publicacao() {
        return ano_publicacao;
    }

    public void setAno_publicacao(int ano_publicacao) {
        if (ano_publicacao>2024) {
            throw new IllegalArgumentException("não existe livro publicado no futuro");
        }
        this.ano_publicacao = ano_publicacao;
    }


    public int getNumero_paginas() {
        return numero_paginas;
    }
    public void setNumero_paginas(int numero_paginas) {
        if (numero_paginas<=0) {
            throw new IllegalArgumentException("não é possivel");
        }
        this.numero_paginas = numero_paginas;
    }

    public void setPagina_atual(int pagina_atual) {
        if (pagina_atual<0 || pagina_atual> numero_paginas+1) {
                throw new IllegalArgumentException("pagina não existe");
        }
        this.pagina_atual = pagina_atual;
    }

    public int getPagina_atual() {
        return pagina_atual;
    }

    public int getPagina_marcada(){
        return pagina_marcada;
    }

    public String abrir(){
        if(pagina_atual> 0 && pagina_atual<=numero_paginas) {
            throw new IllegalArgumentException("O livro já está aberto");
        }
        pagina_atual = (pagina_marcada != -1) ? pagina_marcada : 1;
        return "abrir livro";
    }

    public String fechar(){
        if(pagina_atual== 0 || pagina_atual>numero_paginas) {
            throw new IllegalArgumentException("O livro já está fechado");
        }
        setPagina_atual(numero_paginas+1);
        return "fechar Livro";
    }

    public void marcar_pagina(){
        if(pagina_atual> 0 && pagina_atual<=numero_paginas) {
            this.pagina_marcada = pagina_atual;
        }
        else{
            throw new IllegalArgumentException("não pode marcar a capa");
        }

    }

    public void avancar_pagina(){
        if(pagina_atual<=numero_paginas){
            this.pagina_atual++;
        }
        else {
            throw new IllegalArgumentException("Já está na contracapa");
        }
    }

    public void retroceder_pagina(){
        if(pagina_atual>0){
            this.pagina_atual--;
        }
        else {
            throw new IllegalArgumentException("Já está na capa");
        }
    }

}
