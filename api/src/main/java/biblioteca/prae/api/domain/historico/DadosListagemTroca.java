package biblioteca.prae.api.domain.historico;

import biblioteca.prae.api.domain.livro.Genero;
import biblioteca.prae.api.domain.livro.Livro;
import biblioteca.prae.api.domain.usuario.Usuario;

public record DadosListagemTroca(Long id, Usuario usuarioId, Livro livroEntrada, Livro LivroSaida) {
    public DadosListagemTroca(Troca troca) {
        this(troca.getId(), troca.getUsuario(), troca.getLivroEntrada(), troca.getLivroSaida());
    }
}

