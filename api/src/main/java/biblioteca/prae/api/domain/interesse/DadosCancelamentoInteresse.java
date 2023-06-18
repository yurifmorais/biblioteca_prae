package biblioteca.prae.api.domain.interesse;

import jakarta.validation.constraints.NotNull;

public record DadosCancelamentoInteresse(
        @NotNull
        Long idInteresse) {
}