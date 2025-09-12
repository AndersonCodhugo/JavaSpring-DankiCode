package br.com.livrariadankicode.livrariacursodaki.livros;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping("/livros")
@RequiredArgsConstructor
public class LivrosController {

    private final LivrosService livrosService;

    @PostMapping
        public ResponseEntity<LivrosDTO> cadastrar(@RequestBody @Valid LivrosDTO dto, UriComponentsBuilder uriBuilder) {

        LivrosDTO livrosDTO = livrosService.criarLivro(dto);
        URI endereco = uriBuilder.path("/livros/{id}").buildAndExpand(livrosDTO.getId()).toUri();

        return ResponseEntity.created(endereco).body(livrosDTO);
    }

    @GetMapping
        public ResponseEntity<Page<LivrosDTO>> buscasTodos(@PageableDefault(size = 10) Pageable paginacao) {
            Page<LivrosDTO> livros = livrosService.buscarTodos(paginacao);
            return ResponseEntity.ok(livros);
    }

    @GetMapping("/{id}")
        public ResponseEntity<LivrosDTO> buscarPorId(@PathVariable @NotNull Long id) {

        LivrosDTO livrosDTO = livrosService.buscarPorId(id);
        return ResponseEntity.ok(livrosDTO);
    }

    @PutMapping("/{id}")
        public ResponseEntity<LivrosDTO> atualizar(@RequestBody @Valid LivrosDTO dto, @PathVariable @NotNull Long id) {

        LivrosDTO livroAtualizado = livrosService.atualizarLivro(id, dto);
        return ResponseEntity.ok(livroAtualizado);
    }

    @DeleteMapping("/{id}")
        public ResponseEntity<Void> remover(@PathVariable @NotNull Long id) {
            livrosService.remover(id);
            return ResponseEntity.noContent().build();
    }
}
