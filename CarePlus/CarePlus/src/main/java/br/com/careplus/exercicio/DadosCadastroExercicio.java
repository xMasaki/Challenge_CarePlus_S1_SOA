package br.com.careplus.exercicio;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;
import java.util.Date;

public record DadosCadastroExercicio(
        @NotNull
        Long id,

        @NotNull
        @Temporal(TemporalType.DATE)
        LocalDate data,

        @NotBlank
        @Pattern(regexp = "[0-9]{3}")
        Integer tempo,

        @NotNull
        EspecialidadeModeracao especialidadeModeracao,

        @NotNull
        EspecialidadeSentimento especialidadeSentimento) {


}
