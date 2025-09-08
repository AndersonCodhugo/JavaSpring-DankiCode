package br.com.livrariadankicode.livrariacursodaki.livros;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Livros")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Livros {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private int anoLancamento;

    private double preco;

    private boolean disponivel;
    
    @Enumerated(EnumType.STRING)
    private Genero genero;

    @Enumerated(EnumType.STRING)
    private Autor autor;
    
}
