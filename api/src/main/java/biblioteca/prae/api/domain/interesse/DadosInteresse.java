package biblioteca.prae.api.domain.interesse;

import jakarta.validation.constraints.NotNull;

//verificar se nao preciso mudar os nomes dos atributos para deixar igual ao bd
public record DadosInteresse(
        Long idLivro,
        @NotNull
        Long idUsuario
) {
}
