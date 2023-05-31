package biblioteca.prae.api.domain.livro;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

//primeiro passa o tipo da entidade e o segundo argumento eh o tipo do atributo da pk dessa entidade
public interface LivroRepository extends JpaRepository<Livro, Long> {
    Page<Livro> findAllByDisponivelTrue(Pageable paginacao);
}

