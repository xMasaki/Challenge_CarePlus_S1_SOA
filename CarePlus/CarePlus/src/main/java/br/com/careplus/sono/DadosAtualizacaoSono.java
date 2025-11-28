package br.com.careplus.sono;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;
import java.util.Date;

public record DadosAtualizacaoSono(
        @NotNull
        Long id,
        LocalDate data,
        Float horasSono,
        Integer tempoParaDormir,
        Integer vezesAcordados,
        Boolean acordouBem) {
}
