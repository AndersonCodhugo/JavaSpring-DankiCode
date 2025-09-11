package br.com.livrariadankicode.livrariacursodaki.livros;


import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LivrosDTO {

    @NotBlank
    private String titulo;

    private Autor autor;

    private Genero genero;

    @JsonProperty("ano_lancamento")
    private int anoLancamento;

    @Positive
    private double preco;

    private boolean disponivel;

}
