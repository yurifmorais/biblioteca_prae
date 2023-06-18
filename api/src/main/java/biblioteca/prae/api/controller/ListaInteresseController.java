package biblioteca.prae.api.controller;

import biblioteca.prae.api.domain.interesse.DadosCancelamentoInteresse;
import biblioteca.prae.api.domain.interesse.DadosDetalhamentoInteresse;
import biblioteca.prae.api.domain.interesse.DadosInteresse;
import biblioteca.prae.api.domain.interesse.ListaDeInteresse;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("listainteresse")
public class ListaInteresseController {

    @Autowired
    private ListaDeInteresse interesse;

    @PostMapping
    @Transactional
    public ResponseEntity adicionarNaListaInteresse(@RequestBody @Valid DadosInteresse dados){
        //DadosInteresse e o que vou receber do front
        //DadosDetalhamentoInteresse e o que eu vou retornar

        interesse.adicionarALista(dados); //o controller nao deve ter regras de negocio
        return ResponseEntity.ok(new DadosDetalhamentoInteresse(null, null, null));
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity cancelarInteresse(@RequestBody @Valid DadosCancelamentoInteresse dados) {
        interesse.cancelar(dados);
        return ResponseEntity.noContent().build();
    }
}
