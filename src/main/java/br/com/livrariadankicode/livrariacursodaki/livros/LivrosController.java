package br.com.livrariadankicode.livrariacursodaki.livros;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
@RequiredArgsConstructor
public class LivrosController {

    private final LivrosService livrosService;

    @PostMapping
        public void cadastrar(@RequestBody @Valid LivrosDTO dto) {

        livrosService.criarLivro(dto);
    }

    @GetMapping
        public List<LivrosDTO> buscasTodos() {
            return livrosService.buscarTodos();
    }
}
