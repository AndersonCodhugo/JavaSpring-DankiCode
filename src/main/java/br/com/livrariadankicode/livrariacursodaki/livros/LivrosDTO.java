package br.com.livrariadankicode.livrariacursodaki.livros;


import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LivrosDTO {

    private String titulo;

    private Autor autor;

    private Genero genero;

    private int anoLancamento;

    private double preco;

    private boolean disponivel;

}
