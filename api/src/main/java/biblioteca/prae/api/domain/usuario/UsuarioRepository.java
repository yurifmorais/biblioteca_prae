package biblioteca.prae.api.domain.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

//@Repository//teste
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    UserDetails findByEmail(String username);
}
