package biblioteca.prae.api.controller;

import biblioteca.prae.api.domain.historico.DadosTroca;
import biblioteca.prae.api.domain.historico.Troca;
import biblioteca.prae.api.domain.historico.TrocaRepository;
import biblioteca.prae.api.domain.livro.Livro;
import biblioteca.prae.api.domain.livro.LivroRepository;
import biblioteca.prae.api.domain.usuario.Usuario;
import biblioteca.prae.api.domain.usuario.UsuarioRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/trocas")
@SecurityRequirement(name = "bearer-key")

public class TrocaController {
    @Autowired
    private TrocaRepository trocaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private LivroRepository livroRepository;

    @GetMapping
    public List<Troca> listar() {
        return trocaRepository.findAll();
    }

    @PostMapping
    public Troca adicionar(@RequestBody DadosTroca dadosTroca) {
        Usuario usuario = usuarioRepository.findById(dadosTroca.usuarioId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));
        Livro livroEntrada = livroRepository.findById(dadosTroca.livroEntradaId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro de entrada não encontrado"));
        Livro livroSaida = livroRepository.findById(dadosTroca.livroSaidaId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro de saída não encontrado"));
        Troca troca = new Troca(usuario, livroEntrada, livroSaida, dadosTroca.data());
        return trocaRepository.save(troca);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        trocaRepository.deleteById(id);
    }
}
