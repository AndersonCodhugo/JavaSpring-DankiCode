package br.com.livrariadankicode.livrariacursodaki.config;

import br.com.livrariadankicode.livrariacursodaki.user.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    public String gerarToken(Usuario usuario) {
        try {
            Algorithm algoritmo = Algorithm.HMAC256("1234");
            LocalDateTime tempoFinal = LocalDateTime.now().plusHours(2);
            return JWT.create().withIssuer("Livraria Danki")
                    .withSubject(usuario.getLogin())
                    .withExpiresAt(tempoFinal.toInstant(ZoneOffset.of("-03:00")))
                    .sign(algoritmo);
        } catch (JWTCreationException e) {
            throw new RuntimeException("Erro na geração do token", e);
        }

    }

    public String buscarUsuarioToken(String token) {
        try {
            Algorithm algoritmo = Algorithm.HMAC256("1234");
            return JWT.require(algoritmo)
                    .withIssuer("Livraria Danki")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException ex) {
            throw new RuntimeException("Token não encontrado!");

        }
    }
}
