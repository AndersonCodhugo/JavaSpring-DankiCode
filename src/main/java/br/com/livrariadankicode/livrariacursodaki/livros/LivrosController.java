package br.com.livrariadankicode.livrariacursodaki.livros;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livros")
@RequiredArgsConstructor
public class LivrosController {

    private final LivrosService livrosService;

@PostMapping
    public void cadastrar(@RequestBody LivrosDTO dto) {
        livrosService.criarLivro(dto);
    }
}
