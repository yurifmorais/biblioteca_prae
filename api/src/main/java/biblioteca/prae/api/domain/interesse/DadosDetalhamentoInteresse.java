package biblioteca.prae.api.domain.interesse;

public record DadosDetalhamentoInteresse(Long id, Long idLivro, Long idUsuario) {
    public DadosDetalhamentoInteresse(Interesse interesse) {
        this(interesse.getId(), interesse.getUsuario().getId(), interesse.getLivro().getId());
    }
}
