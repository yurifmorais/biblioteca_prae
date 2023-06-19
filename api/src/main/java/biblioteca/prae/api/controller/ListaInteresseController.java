package biblioteca.prae.api.controller;

import biblioteca.prae.api.domain.interesse.DadosCancelamentoInteresse;
import biblioteca.prae.api.domain.interesse.DadosDetalhamentoInteresse;
import biblioteca.prae.api.domain.interesse.DadosInteresse;
import biblioteca.prae.api.domain.interesse.ListaDeInteresse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//preciso verificar para nao duplicar o livro na lista de interesse
@RestController
@RequestMapping("listainteresse")
@SecurityRequirement(name = "bearer-key")
public class ListaInteresseController {

    @Autowired
    private ListaDeInteresse interesse;

    @PostMapping
    @Transactional
    public ResponseEntity adicionarNaListaInteresse(@RequestBody @Valid DadosInteresse dados){
        //DadosInteresse e o que vou receber do front
        //DadosDetalhamentoInteresse e o que eu vou retornar

        var dto = interesse.adicionarALista(dados); //o controller nao deve ter regras de negocio
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity cancelarInteresse(@RequestBody @Valid DadosCancelamentoInteresse dados) {
        interesse.cancelar(dados);
        return ResponseEntity.noContent().build();
    }
}
