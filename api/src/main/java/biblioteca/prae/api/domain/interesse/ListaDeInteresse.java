package biblioteca.prae.api.domain.interesse;
import biblioteca.prae.api.domain.ValidacaoException;
import biblioteca.prae.api.domain.livro.LivroRepository;
import biblioteca.prae.api.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListaDeInteresse {

    @Autowired
    private InteresseRepository interesseRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private LivroRepository livroRepository;

    //a lista de interesse vai fazer algo de reservar?
    public DadosDetalhamentoInteresse adicionarALista(DadosInteresse dados){
        if(!usuarioRepository.existsById(dados.idUsuario())){
            //se o id do usuario nao existir no meu bd
            throw new ValidacaoException("ID do usuario informado nao existe!");
        }

        if(!livroRepository.existsById(dados.idLivro())){
            //se o id do livro nao existir no meu bd
            throw new ValidacaoException("ID do livro informado nao existe!");
        }

//        var usuario = usuarioRepository.findById(dados.idUsuario()).get();
        //var livro = livroRepository.findById(dados.idLivro()).get();
        var usuario = usuarioRepository.getReferenceById(dados.idUsuario());
        var livro = livroRepository.getReferenceById(dados.idLivro());

        var interesse = new Interesse(usuario, livro);
        interesseRepository.save(interesse);

        return new DadosDetalhamentoInteresse(interesse);
    }
}
