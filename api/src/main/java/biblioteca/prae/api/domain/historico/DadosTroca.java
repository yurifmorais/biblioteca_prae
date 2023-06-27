package biblioteca.prae.api.domain.historico;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosTroca(
        @NotNull
        Long usuarioId,
        @NotNull
        Long livroEntradaId,
        @NotNull Long livroSaidaId,
        LocalDateTime data
) {
}
