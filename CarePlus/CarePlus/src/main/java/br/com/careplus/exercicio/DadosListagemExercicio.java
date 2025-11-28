package br.com.careplus.exercicio;

import java.time.LocalDate;
import java.util.Date;

public record DadosListagemExercicio(
        Long id,
        LocalDate data,
        Integer tempo,
        EspecialidadeModeracao especialidadeModeracao,
        EspecialidadeSentimento especialidadeSentimento,
        Long clienteId) {

    public DadosListagemExercicio(Exercicio exercicio){
        this(exercicio.getId(), exercicio.getData(), exercicio.getTempo(), exercicio.getEspecialidadeModeracao(), exercicio.getEspecialidadeSentimento(), exercicio.getClienteId());
    }
}
