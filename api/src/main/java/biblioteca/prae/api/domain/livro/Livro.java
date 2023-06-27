package biblioteca.prae.api.domain.livro;

//entidade JPA para representar a tabela LIVRO do BD.
//tem os mesmos atributos que declarei no record DadosCadastroMedico

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Blob;

@Table(name = "livros")
@Entity(name = "Livro")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")//pk

public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String autor;
    private Blob foto;
    @Enumerated(EnumType.STRING)
    private Genero genero;
    private boolean disponivel;
    private int quantidade;

    public Livro(DadosCadastroLivro dados) {
        this.titulo = dados.titulo();
        this.autor = dados.autor();
        this.foto = dados.foto();
        this.genero = dados.genero();
        this.disponivel = true;
        this.quantidade = dados.quantidade();
    }

    public void atualizarInformacoes(DadosAtualizacaoLivro dados) {
        if (dados.titulo() != null) {
            this.titulo = dados.titulo();
        }
        if (dados.autor() != null) {
            this.autor = dados.autor();
        }
        if (dados.genero() != null) {
            this.genero = dados.genero();
        }
    }

    //exclusao logica em que eu so desativo o livro
    public void excluir() {
        this.disponivel = false;
    }
}