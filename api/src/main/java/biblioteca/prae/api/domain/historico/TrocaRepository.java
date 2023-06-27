package biblioteca.prae.api.domain.historico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface TrocaRepository extends JpaRepository<Troca, Long> {
}