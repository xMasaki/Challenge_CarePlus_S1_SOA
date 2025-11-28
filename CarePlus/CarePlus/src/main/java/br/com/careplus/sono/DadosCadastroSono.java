package br.com.careplus.sono;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

public record DadosCadastroSono(
        @NotNull
        Long id,

        @NotNull
        @Temporal(TemporalType.DATE)
        LocalDate data,

        @NotBlank
        @Pattern(regexp = "^[0-9]+(\\.[0-9])?$")
        Float horasSono,

        @Pattern(regexp = "[0-9]{2,3}")
        Integer tempoParaDormir,

        @NotBlank
        @Pattern(regexp = "[0-9]{1}")
        Integer vezesAcordados,

        @NotBlank
        Boolean acordouBem
) {

}
