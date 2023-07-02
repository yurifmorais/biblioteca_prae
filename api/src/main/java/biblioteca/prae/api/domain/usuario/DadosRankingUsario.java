package biblioteca.prae.api.domain.usuario;

public record DadosRankingUsario(String email, long pontuacao) {
    public DadosRankingUsario(Usuario usuario) {
        this(usuario.getEmail(), usuario.getPontuacao());
    }
}