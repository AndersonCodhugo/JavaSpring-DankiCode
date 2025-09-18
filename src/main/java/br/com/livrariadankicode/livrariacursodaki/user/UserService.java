package br.com.livrariadankicode.livrariacursodaki.user;

import br.com.livrariadankicode.livrariacursodaki.config.CriptografiaSenha;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {

    private final UserRepository repository;

    private final ModelMapper modelMapper;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return repository.findByLogin(login);
    }

    public DadosUsuarioCadastro criarUsuario(@Valid DadosUsuarioCadastro dto) {
        Usuario usuario = modelMapper.map(dto, Usuario.class);

        String senhaCriptografada = CriptografiaSenha.criptografia(usuario.getPassword());
        usuario.setPassword(senhaCriptografada);
        repository.save(usuario);
        return modelMapper.map(usuario, DadosUsuarioCadastro.class);
    }
}
