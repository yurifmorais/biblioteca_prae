package biblioteca.prae.api.domain.historico;

public record DadosListagemTroca(Long id, Long idUsario, String nomeUsuario, String emailUsuario, Long idLivroEntrada, String livroEntrada, String livroSaida, Long idLivroSaida) {
    public DadosListagemTroca(Troca troca) {
        this(troca.getId(), troca.getUsuario().getId(), troca.getUsuario().getNome(),  troca.getUsuario().getEmail(), troca.getLivroEntrada().getId(), troca.getLivroEntrada().getTitulo(), troca.getLivroSaida().getTitulo(), troca.getLivroSaida().getId());
    }
}