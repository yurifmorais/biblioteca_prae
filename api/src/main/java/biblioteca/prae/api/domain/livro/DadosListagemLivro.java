package biblioteca.prae.api.domain.livro;

//como eu nao preciso listar todos os dados di livro, vou criar um DTO com os dados de interesse
public record DadosListagemLivro(Long id, String titulo, String autor, Genero genero) {
    public DadosListagemLivro(Livro livro) {
        this(livro.getId(), livro.getTitulo(), livro.getAutor(), livro.getGenero());
    }
}