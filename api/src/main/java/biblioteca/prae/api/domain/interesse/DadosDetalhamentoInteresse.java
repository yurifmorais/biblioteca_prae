package biblioteca.prae.api.domain.interesse;

public record DadosDetalhamentoInteresse(Long idLivro, Long idUsuario) {
    public DadosDetalhamentoInteresse(Interesse interesse) {
        this(interesse.getUsuario().getId(), interesse.getLivro().getId());
    }
}
