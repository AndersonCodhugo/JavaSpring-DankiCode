package br.com.livrariadankicode.livrariacursodaki.livros;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LivrosService {

    private final LivrosRepository livrosRepository;

    private final ModelMapper modelMapper;

    public LivrosDTO criarLivro(LivrosDTO dto) {
        Livros livro = modelMapper.map(dto, Livros.class);
        livrosRepository.save(livro);

        return modelMapper.map(livro, LivrosDTO.class);
    }

    public Page<LivrosDTO> buscarTodos(Pageable paginacao) {
        return livrosRepository.findAll(paginacao).map(l -> modelMapper.map(l, LivrosDTO.class));
    }

    public LivrosDTO buscarPorId(Long id) {
        Livros livro = livrosRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        return modelMapper.map(livro, LivrosDTO.class);
    }

    public LivrosDTO atualizarLivro(Long id, LivrosDTO dto) {
        Livros livro = modelMapper.map(dto, Livros.class);
        livro.setId(id);
        livro = livrosRepository.save(livro);
        return modelMapper.map(livro, LivrosDTO.class);
    }

    public void remover(@NotNull Long id) {
        livrosRepository.deleteById(id);
    }
}

