package biblioteca.prae.api.controller;
import biblioteca.prae.api.domain.livro.DadosDetalhamentoLivro;
import biblioteca.prae.api.domain.livro.LivroRepository;
import biblioteca.prae.api.domain.usuario.DadosCadastroUsuario;
import biblioteca.prae.api.domain.usuario.Usuario;
import biblioteca.prae.api.domain.usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/cadastro")
public class CadastroController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    @Transactional
    public ResponseEntity efetuarCadastro(@RequestBody @Valid DadosCadastroUsuario dados) {
        var usuario = new Usuario(dados);
        usuarioRepository.save(usuario); //o save eh como se fosse um INSERT no bd
        return ResponseEntity.noContent().build(); //verificar se encaminho para algum lugar apos realizar o cadastro
    }
}
//o cadastro funciona, mas preciso criptografar a senha