package br.com.livrariadankicode.livrariacursodaki.livros;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
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

    @GetMapping("/{id}")
        public LivrosDTO buscarPorId(@PathVariable @NotNull Long id) {

        return livrosService.buscarPorId(id);
    }

    @PutMapping("/{id}")
        public LivrosDTO atualizar(@RequestBody @Valid LivrosDTO dto, @PathVariable @NotNull Long id) {

        LivrosDTO livroAtualizado = livrosService.atualizarLivro(id, dto);
        return livroAtualizado;
    }

    @DeleteMapping("/{id}")
        public void remover(@PathVariable @NotNull Long id) {
            livrosService.remover(id);
    }
}
