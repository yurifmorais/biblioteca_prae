package biblioteca.prae.api.domain.interesse;

import java.io.Serializable;
import java.util.Objects;

public class InteresseId implements Serializable {
    private Long usuario;
    private Long livro;

    public InteresseId() {}

    public InteresseId(Long usuario, Long livro) {
        this.usuario = usuario;
        this.livro = livro;
    }

    public Long getUsuario() {
        return usuario;
    }

    public void setUsuario(Long usuario) {
        this.usuario = usuario;
    }

    public Long getLivro() {
        return livro;
    }

    public void setLivro(Long livro) {
        this.livro = livro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InteresseId)) return false;
        InteresseId that = (InteresseId) o;
        return Objects.equals(getUsuario(), that.getUsuario()) &&
                Objects.equals(getLivro(), that.getLivro());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsuario(), getLivro());
    }
}
