package biblioteca.prae.api.controller;
import biblioteca.prae.api.domain.usuario.DadosAutenticacao;
import biblioteca.prae.api.domain.usuario.Usuario;
import biblioteca.prae.api.domain.usuario.UsuarioRepository;
import biblioteca.prae.api.infra.security.DadosTokenJWT;
import biblioteca.prae.api.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//JWT -> json web token
@RestController
@RequestMapping("/login")
public class AutenticacaoController {
    @Autowired
    private UsuarioRepository usuarioRepository; //testeeee
    @Autowired
    private AuthenticationManager manager;
    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {
        try {
            var authenticationToken = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());
            var authentication = manager.authenticate(authenticationToken);
            var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());

            Usuario usuario = (Usuario) usuarioRepository.findByEmail(dados.email());
            return ResponseEntity.ok(new DadosTokenJWT(tokenJWT, dados.email(), usuario.getNome(), usuario.getId(), usuario.isAdmin()));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
