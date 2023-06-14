package biblioteca.prae.api.domain.usuario;

import biblioteca.prae.api.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService implements UserDetailsService {  //tem que implementar para o spring saber que e de autenticacao, ele faz isso automaticamente
    @Autowired
    private UsuarioRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //return repository.findByLogin(username);
        return repository.findByEmail(username);
    }

}
