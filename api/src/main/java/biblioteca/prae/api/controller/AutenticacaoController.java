package biblioteca.prae.api.controller;
import biblioteca.prae.api.domain.usuario.DadosAutenticacao;
import biblioteca.prae.api.domain.usuario.Usuario;
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
    private AuthenticationManager manager; //classe que o proprio spring usa pra fazer a autenticacao

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {
        try {
            var authenticationToken = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());
            var authentication = manager.authenticate(authenticationToken);

            var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());

            return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}




//@RestController
//@RequestMapping("/login")
//public class AutenticacaoController {
//    @Autowired //injecao de dependencia o spring vai fazer
//    private AuthenticationManager manager; //classe que o proprio spring usa pra fazer a autenticacao
//
//    @Autowired
//    private TokenService tokenService;
//
//    @PostMapping
//    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados){
//
//        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());
//        var authentication = manager.authenticate(authenticationToken);
//
//        //o usuario esta dentro da variavel authentication, ai so pego ele e faco o cast
//        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());
//        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
//    }
//}