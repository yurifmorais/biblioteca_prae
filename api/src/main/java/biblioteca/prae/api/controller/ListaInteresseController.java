package biblioteca.prae.api.controller;

import biblioteca.prae.api.domain.interesse.DadosInteresse;
import biblioteca.prae.api.domain.interesse.InteresseRepository;
import biblioteca.prae.api.domain.interesse.ListaDeInteresse;
import biblioteca.prae.api.domain.livro.DadosListagemLivro;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("listainteresse")
@SecurityRequirement(name = "bearer-key")
public class ListaInteresseController {

    @Autowired
    private ListaDeInteresse interesse;

    @Autowired
    private InteresseRepository interesseRepository;

    @PostMapping
    @Transactional
    public ResponseEntity adicionarNaListaInteresse(@RequestBody @Valid DadosInteresse dados){
        //DadosInteresse e o que vou receber do front
        //DadosDetalhamentoInteresse e o que eu vou retornar

        var dto = interesse.adicionarALista(dados); //o controller nao deve ter regras de negocio
        return ResponseEntity.ok(dto);
    }
}
