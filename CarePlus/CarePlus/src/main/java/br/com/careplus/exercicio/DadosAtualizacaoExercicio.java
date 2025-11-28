package br.com.careplus.exercicio;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Date;

public record DadosAtualizacaoExercicio(
        @NotNull
        Long id,
        LocalDate data,
        Integer tempo,
        EspecialidadeModeracao especialidadeModeracao,
        EspecialidadeSentimento especialidadeSentimento,
        Long clienteId
) {
}
