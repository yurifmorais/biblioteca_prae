package biblioteca.prae.api.domain.historico;

import biblioteca.prae.api.domain.livro.Genero;
import biblioteca.prae.api.domain.livro.Livro;

public record DadosDetalhamentoTroca(Long id, Long usuarioID, Long livroEntradaID, Long livroSaidaID) {
    public DadosDetalhamentoTroca(Troca troca) {
        this(troca.getId(), troca.getUsuario().getId(), troca.getLivroEntrada().getId(), troca.getLivroSaida().getId());
    }
}