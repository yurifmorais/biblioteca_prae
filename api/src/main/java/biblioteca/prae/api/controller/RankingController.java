package biblioteca.prae.api.controller;
import biblioteca.prae.api.domain.usuario.DadosRankingUsario;
import biblioteca.prae.api.domain.usuario.Usuario;
import biblioteca.prae.api.domain.usuario.UsuarioRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ranking")
@SecurityRequirement(name = "bearer-key")

public class RankingController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping
    public ResponseEntity<List<DadosRankingUsario>> getUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<DadosRankingUsario> ranking = usuarios.stream()
                .map(usuario -> new DadosRankingUsario(usuario.getEmail(), usuario.getPontuacao()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(ranking);
    }

//    @GetMapping("/{email}/classificacao")
//    public ResponseEntity<?> getClassificacao(@PathVariable String email) {
//        List<Usuario> usuarios = usuarioRepository.findAll(Sort.by(Sort.Direction.DESC, "pontuacao"));
//        int classificacao = 1;
//        for (Usuario usuario : usuarios) {
//            if (usuario.getEmail().equals(email)) {
//                return ResponseEntity.ok(Map.of("classificacao", classificacao));
//            }
//            classificacao++;
//        }
//        return ResponseEntity.notFound().build();
//    }

    @GetMapping("/{email}/classificacao")
    public ResponseEntity<?> getClassificacao(@PathVariable String email) {
        List<Usuario> usuarios = usuarioRepository.findAll(Sort.by(Sort.Direction.DESC, "pontuacao"));
        int classificacao = 1;
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                return ResponseEntity.ok(Map.of(
                        "classificacao", classificacao,
                        "pontuacao", usuario.getPontuacao()
                ));
            }
            classificacao++;
        }
        return ResponseEntity.notFound().build();
    }

}
