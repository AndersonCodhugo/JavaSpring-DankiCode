package br.com.livrariadankicode.livrariacursodaki.livros;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
}

