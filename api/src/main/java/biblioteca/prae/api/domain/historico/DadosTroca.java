package biblioteca.prae.api.domain.historico;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

//dados que vou receber do front
public record DadosTroca(
//        @NotNull
//        Long usuarioId,
        @NotNull
        String emailUsuario,
        @NotNull
        Long livroEntradaId,
        @NotNull
        Long livroSaidaId,
        LocalDateTime data
) {
}
